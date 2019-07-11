package techcourse.myblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping(value = {"/helloworld","/"}, method = { RequestMethod.GET, RequestMethod.POST })
    public String showBlogPage(@RequestParam(name = "blogName",required = false, defaultValue = "Welcome Brown!") String name,Model model){
        model.addAttribute("blogName",name);
        return "index";
    }
}
