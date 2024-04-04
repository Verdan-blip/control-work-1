package ru.kpfu.itis.bagaviev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.bagaviev.model.SiteReview;

public interface SiteReviewRepository extends JpaRepository<SiteReview, Integer> {

}
