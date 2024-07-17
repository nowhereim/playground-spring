package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MappingController {

//    private Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(
            @PathVariable("userId") String data //  변수명이 같으면 안에 넣을 필요 없음.
    ){
        log.info("mappingPath userId={}", data);
        return "ok";
    };


    /**
     * 쿼리파라미터가 여러개일때는 다음과같이 한번에 받을 수 있다.
     */
    @GetMapping("/mapping-param")
    public String mappingParam(
            String userId,
            int age
    ){
        log.info("mappingParam userId={}, age={}", userId, age);
        return "ok";
    };

    /**
     * 파라미터로 추가 매핑
     * 특정 파라미터가 있어야만 호출되는 경우 사용
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug") // 헤더에 mode=debug가 있어야 호출됨.
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    };

    /**
     * 컨텐트타입이 application/json이어야만 할 경우
     */
    @GetMapping(value = "/mapping-consume", consumes = MediaType.TEXT_HTML_VALUE) // 오른쪽처럼 하드코딩도 된다."application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    };

    /**
     * Accept 헤더 제한
     */
    @GetMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    };
}
