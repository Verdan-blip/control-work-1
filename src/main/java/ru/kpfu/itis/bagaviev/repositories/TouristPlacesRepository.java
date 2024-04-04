package ru.kpfu.itis.bagaviev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.bagaviev.model.TouristPlace;

import java.util.List;

public interface TouristPlacesRepository extends JpaRepository<TouristPlace, Integer> {
    List<TouristPlace> findAllByCity(String city);
}
