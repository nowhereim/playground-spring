package com.example.servlet.basic.reqeust;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet" , urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request, response);
        printHeaders(request, response);
        printHeaderUtils(request, response);
    }

    private static void printStartLine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequest() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());



    }


    //Header 모든 정보
    private void printHeaders(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            String headerValue = request.getHeader(headerName);
//            System.out.println(headerName + ": " + headerValue);
//        }


        request.getHeaderNames().asIterator().forEachRemaining(headerName ->
                System.out.println("headerName = " + headerName));
    }

    //locale
    private void printHeaderUtils(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
    }

    //cookie
    private void printHeaderCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Cookie Name: " + cookie.getName());
                System.out.println("Cookie Value: " + cookie.getValue());
            }
        }
    }
}
