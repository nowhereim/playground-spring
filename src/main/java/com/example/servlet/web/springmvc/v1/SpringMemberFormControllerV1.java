package com.example.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller //인터페이스로 쓰던게 어노테이션으로 바뀜 이것도 개편해진거지. 빈 등록도 어노테이션으로 하게됨 컴포넌특 어노테이션이 내부에 붙어있어서 스캔 대상임.
//@Component
//@RequestMapping //이런식으로 클래스레벨에 붙어있으면 맵핑이 가능함.
public class SpringMemberFormControllerV1 {

    //와 스프링 개편하다.
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        System.out.println("true = " + true);
        return new ModelAndView("new-form");
    }

}
