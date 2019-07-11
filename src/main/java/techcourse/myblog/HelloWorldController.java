package techcourse.myblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String showBlogPage(@RequestParam(name = "blogName", required = false, defaultValue = "Welcome Brown!") String name, Model model) {
        model.addAttribute("blogName", name);
        return "index";
    }

    @PostMapping("/helloworld")
    public String showBlogPage2(@RequestParam(name = "blogName", required = false, defaultValue = "Welcome Brown!") String name, Model model)   {
        model.addAttribute("blogName",name);
        return "index";
    }
}
