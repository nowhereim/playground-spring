package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Controller 이렇게해서 문자 반환하면 뷰 리졸버가 화면을 찾아서 랜더링
@Slf4j
@RestController //얘는 그냥 문자 반환
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
// 롬복쓰면 위에꺼 필요없어짐.
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "gkdgkdg";

        log.trace("trace log = {}, {}", name,"앙");
        //이렇게 하면 안되는 이유는 자바 언어의 특성에 있다. 문자열 연산이 무조건 일어나기 때문에 메모리 씨피유를 쓴다.
        //그래서 이런식으로 쓰면 안됨.
        //log.trace("trace log = " + name);

        //얘는 연산을 쓰지 않음. 파라미트로 넘겨주기 때문에 연산은 없음.

        //sout랑은 또 다른 점은 성능 최적화가 되어있음 , sout는 내부 버퍼 , 멀티 쓰레드 등 로깅에 최적화 되어있지않고 그냥 막 다 씀.
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log={}", name);
        return "ok";
    };
}
