package ru.kpfu.itis.bagaviev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.bagaviev.model.Hotel;

import java.util.List;

public interface HotelsRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByCity(String city);
}
