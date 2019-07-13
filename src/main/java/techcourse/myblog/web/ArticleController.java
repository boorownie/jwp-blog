package techcourse.myblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import techcourse.myblog.domain.ArticleRepository;

import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(){ return "index"; }

    @GetMapping(value = {"articles/new","writing"})
    public String newArticle(){ return "article-edit"; }

    @PostMapping("articles")
    public String saveArticle(@RequestParam Map<String, String> requestParams, Model model){
        model.addAllAttributes(requestParams);
        return "article";
    }
}
