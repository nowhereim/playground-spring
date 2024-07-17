package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){

        return new ModelAndView("response/hello").addObject("data", "hello!");

    }


    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){

        model.addAttribute("data","hello!");

        return "response/hello";
    }

    /**
     * 이건 권장하지않음. 경로와 파일의 경로가 같으면 그냥 반환해주는데 이렇게 쓰는 회사는 탈출해라.
     * @param model
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){

        model.addAttribute("data","hello!");

    }
}
