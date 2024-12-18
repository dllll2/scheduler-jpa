//package com.example.schedulerjpa.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//public class AuthFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        String uri = httpRequest.getRequestURI();
//
//        // 로그인과 회원가입 요청은 필터 제외
//        if (uri.contains("/auth/login") || uri.contains("/auth/logout")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        HttpSession session = httpRequest.getSession(false);
//        if (session == null || session.getAttribute("memberId") == null) {
//            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
//            return;
//        }
//
//        chain.doFilter(request, response);
//    }
//}