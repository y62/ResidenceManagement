package com.example.bas.Controller;

import com.example.bas.Service.Model.News;
import com.example.bas.Service.News.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
/**
 * Vi annotere klassen som Controller.
 * Autowirer pga. dependency injection.
 * Mapper HTTP requests til metoder.
 */
@Controller
public class NewsController {
    @Autowired
    NewsServiceImpl newsService;

    @GetMapping("news/newsUpdate/{newsId}")
    public String updateNews(@PathVariable Integer newsId, Model model) {
        model.addAttribute("news", newsService.findNewsById(newsId).get());
        return "newsUpdate";
    }

    @PostMapping("/newsUpdate")
    public String updateNews(@ModelAttribute News news) {
        newsService.updateNews(news);
        return "redirect:/news/1";
    }
    @GetMapping("/news/{newsId}")
    public String news(@PathVariable int newsId, Model model) {
        Optional<News> news = newsService.findNewsById(newsId);
        model.addAttribute("news", news.get());

        return "news";
    }
}
