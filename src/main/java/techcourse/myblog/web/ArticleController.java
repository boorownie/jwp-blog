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
    public String index(Model model){
        model.addAttribute("articles",articleRepository.findAll());
        return "index";
    }

    @GetMapping(value = {"articles/new","writing"})
    public String newArticle(){ return "article-edit"; }

    @PostMapping("articles")
    public String saveArticle(Article article, Model model){
        model.addAttribute(article);
        articleRepository.add(article);
        return "article";
    }

    @GetMapping("articles/{articlesId}")
    public String articlesId(@PathVariable String articlesId, Model model) {
        Article article = articleRepository.getById(Integer.parseInt(articlesId));
        if (article != null) {
            model.addAttribute(article);
            return "article";
        }
        return "error";
    }
}
