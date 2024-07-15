package com.example.servlet.basic.response;

import com.example.servlet.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-Type: application/json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8"); //이게 필요없음. 애플리케이션 제이슨 타입은 자동으로 utf-8을 사용하도록 되어있어서 의미없음.

        HelloData helloData = new HelloData();
        helloData.setName("kim");
        helloData.setAge(20);

        String result = objectMapper.writeValueAsString(helloData);

        System.out.println("result = " + result);

        PrintWriter writer = resp.getWriter();
        writer.write(result);
        writer.flush();
    }
}
