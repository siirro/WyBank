package com.wybank.security.filter;

import com.google.gson.Gson;
import com.wybank.member.dto.MemberDTO;
import com.wybank.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        log.info("체크중인 uri?? " + path);
        if(path.contains("/api/member/")){
            return true;
        }

        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("--------------------------------------DOFILTERINTERNAL");
        String authHeaderStr = request.getHeader("Authorization");
        //Bearer //7 JWT문자열

        try {
        String accessToken = authHeaderStr.substring(7);
        Map<String, Object> claims = JWTUtil.validateToken(accessToken);

        // todo 이부분 db 쓰지않고 redis 쓰면 굉장히 좋다.
        log.info("JWT claims : "+claims);

        String userId = (String)claims.get("userId");
        String userName = (String)claims.get("userName");
        String pw = (String)claims.get("pw");
        String phone = (String)claims.get("phone");
        Boolean social = (Boolean)claims.get("social");
        Boolean isDeleted = (Boolean)claims.get("isDeleted");
        List<String> roleNames = (List<String>) claims.get("roleNames");
        LocalDateTime createdAt = (LocalDateTime) claims.get("createdAt");
        LocalDateTime updatedAt = (LocalDateTime) claims.get("updatedAt");
        LocalDateTime deletedAt = (LocalDateTime) claims.get("deletedAt");
        MemberDTO memberDTO = new MemberDTO(userId, userName, pw, phone, social, isDeleted, roleNames, createdAt, updatedAt, deletedAt);

        log.info("-------------------------FILTERCHAIN");
        log.info("memberDTO : "+memberDTO);
        log.info("memberDTO : "+memberDTO.getAuthorities());

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(memberDTO, pw, memberDTO.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response); // 다음 목적지로 가게하는 코드

        } catch (Exception e) {
            log.error("JWT Check Error : "+e.getMessage());
            Gson gson = new Gson();
//            String msg = gson.toJson(Map.of("error", "ERROR_ACCESS_TOKEN"));
            String msg = gson.toJson(Map.of("error", e.getMessage()));
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(msg);
            out.close();
        }
    }
}
