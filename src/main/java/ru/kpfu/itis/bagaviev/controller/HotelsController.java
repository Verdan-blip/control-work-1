package ru.kpfu.itis.bagaviev.controller;

import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.bagaviev.model.Hotel;
import ru.kpfu.itis.bagaviev.repositories.HotelsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HotelsController {

    private final HotelsRepository repository;

    public HotelsController(HotelsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "hotels")
    public String hotels() {
        return "hotels";
    }

    @PostMapping(value = "hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String hotels(@ModelAttribute String city) {
        List<Hotel> hotels = repository.findByCity(city);
        JSONArray jsonArray = new JSONArray();
        for (Hotel hotel : hotels) {
            Map<String, Object> map = new HashMap<>();
            map.put("star_rating", hotel.getStarRating());
            map.put("image", hotel.getImage());
            map.put("price_per_night", hotel.getPricePerNight());
            map.put("location", hotel.getLocation());
            jsonArray.put(new JSONObject(map));
        }
        return jsonArray.toString();
    }
}
