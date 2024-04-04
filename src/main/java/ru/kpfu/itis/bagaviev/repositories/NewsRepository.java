package ru.kpfu.itis.bagaviev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.bagaviev.model.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}
