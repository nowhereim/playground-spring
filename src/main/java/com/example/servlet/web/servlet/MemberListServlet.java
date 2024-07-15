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
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
    private final MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //member 데이터를 for문으로 돌면서 html로 만들어서 출력
        PrintWriter writer = resp.getWriter();
        writer.write("<html>\n<body>\n");

        for (Member member : members) {
            writer.write("<div>\n");
            writer.write("<h2>" + member.getId() + "</h2>\n");
            writer.write("<h1>" + member.getUsername() + "</h1>\n");  // assuming getUsername() returns a String
            writer.write("<p>Age: " + member.getAge() + "</p>\n");  // assuming getAge() returns a number
            writer.write("</div>\n");
        }

        writer.write("</body>\n</html>\n");

    }
}
