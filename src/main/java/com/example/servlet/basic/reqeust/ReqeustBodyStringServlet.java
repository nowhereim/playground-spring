package com.example.servlet.basic.reqeust;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyStringServlet",urlPatterns = "/request-body-string")
public class ReqeustBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();// 헤더의 바디값을 바이트코드로 받을 수 있음.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        //이건 진짜 그냥 바디에 텍스트 그대로 때려박힌거 꺼내서 볼때 쓰는거임.
        System.out.println("messageBody = " + messageBody);

        res.getWriter().write("ok");
    }
}
