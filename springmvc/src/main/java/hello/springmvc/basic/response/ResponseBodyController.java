package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
//@Controller
//@ResponseBody
@RestController //위에 두개 합쳐놓은거임.
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyStringV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyStringV2()  {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyStringV3() {
        return "ok";
    }


    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1(){

        HelloData helloData = new HelloData();
        helloData.setUsername("hello");
        helloData.setAge(10);

        return new ResponseEntity<>(helloData,HttpStatus.OK);
    }

    //http상태코드 에너테이션은 다음과같다.
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody //요거 넣으면 리스폰스엔티티안써도되는거임. 근데 스테이터스 설정을 못해서 에너테이션을 추가하는거.
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2(){

        HelloData helloData = new HelloData();
        helloData.setUsername("hello");
        helloData.setAge(10);

        return helloData;
    }
}
