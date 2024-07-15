package com.example.servlet.basic.reqeust;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("parameterNames = " + parameterNames);

        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(req.getParameter(paramName)));

        //단일 파라미터 조회
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        //이름이 같은 파라미터이름을 써서 올수도있음.
        String[] usernames = req.getParameterValues("username");
        if (usernames != null) {
            for (String name : usernames) {
                System.out.println("name = " + name);
            }
        }
    //쓰레드 슬립 하는 코드는 다음과같다.
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
