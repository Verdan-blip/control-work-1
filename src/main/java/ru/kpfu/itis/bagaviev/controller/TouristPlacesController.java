package ru.kpfu.itis.bagaviev.controller;

import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.bagaviev.model.TouristPlace;
import ru.kpfu.itis.bagaviev.repositories.TouristPlacesRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TouristPlacesController {

    private final TouristPlacesRepository repository;

    @Autowired
    public TouristPlacesController(TouristPlacesRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/places")
    public String touristPlaces() {
        return "tourist_places";
    }

    @PostMapping(value = "/places", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String touristPlaces(@ModelAttribute String city) {
        List<TouristPlace> places = repository.findAllByCity(city);
        JSONArray jsonArray = new JSONArray();
        for (TouristPlace place : places) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", place.getName());
            map.put("city", place.getCity());
            map.put("description", place.getDescription());
            map.put("location", place.getLocation());
            map.put("image", place.getImage());
            jsonArray.put(new JSONObject(map));
        }
        return jsonArray.toString();
    }

}
