package com.example.servlet.web.springmvc.v3;
import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(method = RequestMethod.GET) //아 이것도 귀찮게 너무길다.. 해서 나온게?
    @GetMapping
    public String newFrom(
            Model model
    ) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }

//    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
             @RequestParam("age") int age,
             Model model
    ){

        Member member = new Member(username,age);
        memberRepository.save(member);

        model.addAttribute("member",member);
        return "save-result";

    }

//    @RequestMapping(value = "/new-form",method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String members() {
        return "new-form"; //ModelAndView를 반환하지 않아도 뷰의 논리이름을 반환하면 된다. spring이 자동으로 ModelAndView로 변환해준다.
    }
}