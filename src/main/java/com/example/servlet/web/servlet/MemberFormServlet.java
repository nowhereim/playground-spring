package com.example.servlet.web.servlet;

import com.example.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "  <body>\n" +
                        "    <form action=\"/servlet/members/save\" method=\"post\">\n" +
                        "      <label for=\"username\">Username:</label><br>\n" +
                        "      <input type=\"text\" id=\"username\" name=\"username\"><br>\n" +
                        "      <label for=\"age\">Age:</label><br>\n" +
                        "      <input type=\"text\" id=\"age\" name=\"age\"><br>\n" +
                        "      <input type=\"submit\" value=\"Submit\">\n" +
                        "    </form>\n" +
                        "  </body>\n" +
                        "</html>\n"
        );
    }
}

//진짜 서블릿으로 할라니까 궤 같네.