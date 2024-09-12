package com.wybank.controller;

import com.wybank.util.CustomJWTException;
import com.wybank.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class APIRefreshController {

    @RequestMapping("/api/member/refresh")
    public Map<String, Object> refresh(@RequestHeader("Authorization") String authHeader, @RequestParam("refreshToken") String refreshToken) {
        if(authHeader == null || authHeader.length() < 7) {
            throw new CustomJWTException("INVALID_ACCESS_TOKEN");
        }
        if(refreshToken == null) {
            throw new CustomJWTException("NULL_REFRESH_TOKEN");
        }

        String accessToken = authHeader.substring(7);

        //AccessToken의 만료 여부 확인
        log.info("???"+checkExpiredToken(accessToken));

        if(checkExpiredToken(accessToken) == false) {
            return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
        }

        //Refresh토큰 검증
        Map<String, Object> claims = JWTUtil.validateToken(refreshToken);
        log.info("refresh ... claims: " + claims);
        String newAccessToken = JWTUtil.generateToken(claims, 10);
        String newRefreshToken = checkTime((Integer) claims.get("exp")) == true ? JWTUtil.generateToken(claims, 60*24) : refreshToken;

        return Map.of("accessToken", newAccessToken, "refreshToken", newRefreshToken);
    }

    // refresh토근 유효시간이 1시간 미만? refresh토큰 재발급
    private boolean checkTime(Integer exp) {
        Date expDate = new Date((long)exp * (1000));
        long gap = expDate.getTime() - System.currentTimeMillis();
        long leftMin = gap / (1000*60);
        return leftMin < 60;
    }

    private boolean checkExpiredToken(String token) {
        try {
           JWTUtil.validateToken(token);
        } catch (CustomJWTException e) {
            if(e.getMessage().equals("Expired")) {
                return true;
            }
        }
        return false;
    }
}
