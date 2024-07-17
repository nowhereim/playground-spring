package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController("/mapping/users")
@Slf4j
public class MappingClassController {


//    @GetMapping
//    public String user() {
//        log.info("user");
//        return "ok";
//    }
//
//    @PostMapping
//    public String addUser(){
//        return "add user";
//    }
//
//    @GetMapping("/{userId}")
//    public String findUser(
//            @PathVariable String userId
//    ){
//        return "userId=" + userId;
//    }
//
//    @PatchMapping("/{userId}")
//    public String updateUser(
//            @PathVariable String userId
//    ){
//        return "update userId=" + userId;
//    }
//
//    @DeleteMapping("/{userId}")
//    public String deleteUser(
//            @PathVariable String userId
//    ){
//        return "delete userId" + userId;
//    }
}
