package techcourse.myblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import techcourse.myblog.domain.Article;
import techcourse.myblog.domain.ArticleRepository;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(){ return "index"; }

    @GetMapping(value = {"articles/new","writing"})
    public String newArticle(){ return "article-edit"; }

    @PostMapping("articles")
    public String saveArticle(Article article, Model model){
        model.addAttribute(article);
        return "article";
    }
}
