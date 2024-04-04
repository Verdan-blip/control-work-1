package ru.kpfu.itis.bagaviev.controller;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.bagaviev.model.News;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.repositories.NewsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class NewsController {

    private final NewsRepository repository;

    @Autowired
    public NewsController(NewsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "news")
    public String news(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getCredentials();

        List<News> news = repository.findAll();

        model.addAttribute("user", user);
        model.addAttribute("news", news);
        return "news";
    }

    @PostMapping(value = "news", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String news(@ModelAttribute Integer id) {
        Optional<News> newsOptional = repository.findById(id);
        if (newsOptional.isPresent()) {
            News news = newsOptional.get();
            Map<String, Object> map = new HashMap<>();
            map.put("src", news.getText());
            map.put("title", news.getTitle());
            map.put("posting_time", news.getPostingTime().toString());
            map.put("author", news.getAuthor());
            return new JSONObject(map).toString();
        }
        return "{}";
    }
}
