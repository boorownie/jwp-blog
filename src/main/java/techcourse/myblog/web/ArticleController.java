package techcourse.myblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import techcourse.myblog.domain.Article;
import techcourse.myblog.domain.ArticleRepository;
import java.util.Collections;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Article> reversedList = articleRepository.findAll();
        Collections.reverse(reversedList);
        model.addAttribute("articles",reversedList);
        return "index";
    }

    @GetMapping(value = {"articles/new","writing"})
    public String newArticle(){ return "article-edit"; }

    @PostMapping("articles")
    public String saveArticle(Article article, Model model){
        model.addAttribute(article);
        articleRepository.add(article);
        return "redirect:/articles/"+article.getId();
    }

    @GetMapping("articles/{articleId}")
    public String articlesId(@PathVariable String articleId, Model model) {
        Article article = articleRepository.getById(Integer.parseInt(articleId));
        if (article != null) {
            model.addAttribute(article);
            return "article";
        }
        return "error";
    }

    @GetMapping("articles/{articleId}/edit")
    public String articleEdit(@PathVariable String articleId, Model model) {
        Article article = articleRepository.getById(Integer.parseInt(articleId));

        if(article != null){
            model.addAttribute(article);
            return "article-edit";
        }
        return "error";
    }

    @PutMapping("articles/{articleId}")
    public String saveEditArticle(@PathVariable String articleId, Article article, Model model) {
        Article target = articleRepository.getById(Integer.parseInt(articleId));
        if (article != null) {
            target.update(article);
            model.addAttribute("article", target);
        }
        return "article";
    }
}
