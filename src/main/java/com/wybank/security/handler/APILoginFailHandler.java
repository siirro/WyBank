package com.wybank.security.handler;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class APILoginFailHandler implements AuthenticationFailureHandler {
    private static final Logger log = LoggerFactory.getLogger(APILoginFailHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("----login fail..-----------");
        Gson gson = new Gson();
        String json = gson.toJson(Map.of("error", "ERROR_LOGIN_FAIL"));
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.close();
    }
}
