package com.example.feignserver.security;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        try {
            String authorizationValue = httpRequest.getHeader("Authorization");
            String token = authorizationValue.split(" ")[1];
            if(!"mytoken".equals(token)){
                throw new RuntimeException("Invalid token");
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendError(401, "No token or invalid token provided");
        }
    }
}
