package com.example.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);


//        resp.setHeader("Content-Type","text/html;charset=utf-8");
//        resp.setHeader("Cache-Control","no-cache , no-store , no-revalidate");
//        resp.setHeader("Pragma","no-cache");
//        resp.setHeader("my-header","my-value");

        //이렇게 편하게 쓸 수도 있음.
//        content(resp);
//        cookie(resp);
        redirect(resp);

        //메시지 바디에 박아넣는방법.
        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }

    private void content(HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse resp) throws ServletException, IOException {
        //쌩으로 짜면 이렇게도할 수 있음.
        //resp.setHeader("set-cookie", "myCookie=good"; Max-Age=6000");
        //근데 이건 너무 귀찮고 구림.
        Cookie cookie = new Cookie("my-cookie", "my-value");
        cookie.setMaxAge(600); //600 초
        resp.addCookie(cookie);
    }

    private void redirect(HttpServletResponse resp) throws ServletException, IOException {

//        resp.setStatus(HttpServletResponse.SC_FOUND);
//        resp.setHeader("Location", "/basic/hello-form.html");

        //위 방식은 귀찮아. 아래와처럼 그냥 하면 된다
        resp.sendRedirect("/basic/hello-form.html");
    }
}
