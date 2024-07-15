package com.example.servlet.web.servlet;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("MemberSaveServlet.service");
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);


        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();


        writer.write("<html>\n" +
                "<head>\n" +
                "<title>Member Information</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>\n" +
                "<tr><th>ID</th><th>Name</th><th>Age</th></tr>\n"+
                "<tr><td>" + member.getId() + "</td><td>" + member.getUsername() + "</td><td>" + member.getAge() + "</td></tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");
    }
}
