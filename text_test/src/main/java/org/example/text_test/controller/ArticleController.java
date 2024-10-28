package org.example.text_test.controller;

import org.example.text_test.entity.Article;
import org.example.text_test.repository.ArticleRepository;
import org.example.text_test.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("")
    public ModelAndView articlelist(@RequestParam(value = "start",defaultValue = "0")Integer start,
                                    @RequestParam(value = "limit",defaultValue = "5")Integer limit) {
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Article>page = articleRepository.findAll(pageable);
        ModelAndView mav = new ModelAndView("article/list");
        mav.addObject("page", page);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable Integer id) {
        Optional<Article> articles = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", articles);
        return mav;
    }

    @GetMapping("/add")
    public String addArticle() {
        return "article/add";
    }

    @PostMapping("")
    public String saveArticle(Article model){
        articleRepository.save(model);
        return "redirect:/article/";
    }
    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") long id) {
        articleRepository.deleteById(id);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editArticle(@PathVariable("id")long id){
        Article model = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/edit");
        mav.addObject("article",model);
        return mav;
    }

    @PutMapping("/{id}")
    public String editArticleSave(Article model,long id){
        model.setId(id);
        articleRepository.save((model));
        return "redirect:";
    }

}
