package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(
            HttpServletRequest request , HttpServletResponse response
    ) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4( String username, int age ){ //엥? 아에 지워도 된다. 이름만 같으면. ## 대신 단순 타입 String, int ,Integer 같은 단순 타입은 @RequestParam 생략 가능
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) int age //자바에서 기본형에 null이 들어가지않음. Integer로 바꾸든가 해야함.
    ){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true) String username,
            @RequestParam(required = false , defaultValue = "0") int age //자바에서 기본형에 null이 들어가지않음. Integer로 바꾸든가 해야함.
    ){
        log.info("username={}, age={}",username,age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam(required = true)Map<String,Object> paramMap){ //1개의 키에 여러개의 벨류가 있다면 MultiValueMap을 사용하면 된다.
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(
            @ModelAttribute HelloData helloData //객체 프로포티를 찾아서 있으면 셋메서드로 알아서 다 박아넣어줌.
            ){
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(
            HelloData helloData //얘도 이렇게 생략해도 알아서 작동한다. 스프링 쩐다.
    ){
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "ok";
    }
}
