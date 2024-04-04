package ru.kpfu.itis.bagaviev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.bagaviev.dto.SiteReviewDto;
import ru.kpfu.itis.bagaviev.model.SiteReview;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.repositories.SiteReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteReviewsController {

    private final SiteReviewRepository siteReviewRepository;

    @Autowired
    public SiteReviewsController(SiteReviewRepository siteReviewRepository) {
        this.siteReviewRepository = siteReviewRepository;
    }

    @GetMapping("/reviews")
    public String siteReviews(Model model) {
        List<SiteReview> siteReviews = siteReviewRepository.findAll();
        List<SiteReviewDto> siteReviewDtoList = new ArrayList<>();
        for (SiteReview siteReview : siteReviews) {
            User user = siteReview.getUser();
            siteReviewDtoList.add(
                    new SiteReviewDto(
                            siteReview.getText(),
                            user.getAvatar(),
                            user.getName(),
                            siteReview.getDate().toString(),
                            siteReview.getStarRate()
                    )
            );
        }
        model.addAttribute("reviews", siteReviewDtoList);
        return "site_reviews";
    }

}
