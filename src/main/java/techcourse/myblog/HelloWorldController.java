package techcourse.myblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/")
    public String index(){ return "index"; }

    @GetMapping("articles/new")
    public String newArticle(){ return "article-edit"; }
}
