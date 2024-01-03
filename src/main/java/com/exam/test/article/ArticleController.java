package com.exam.test.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = this.articleService.findAll();
        model.addAttribute("articleList",articleList);
        return "article_list";

    }

    @GetMapping("/create")
    public String create(){
        return "article_form";
    }
    @PostMapping("/create")
    public String create(@RequestParam("title") String title, @RequestParam("content") String content){
        articleService.create(title,content);
        return "redirect:/article/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model ,@PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article",article);
        return "article_detail";
    }
}
