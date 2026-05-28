package com.example.cacheredis.controller;

import com.example.cacheredis.entity.Weather;
import com.example.cacheredis.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class CacheController {

    @Autowired
    CacheService cacheService;

    @PostMapping("/saveWeather")
    public ResponseEntity<Weather> saveWeather(@RequestBody Weather weather){
       Weather weather1= cacheService.saveWeather(weather);
       return new ResponseEntity<>(weather1, HttpStatus.CREATED);
    }
    @GetMapping("/getWeather")
    public ResponseEntity<?> getWeather(@RequestParam("city") String city){
       Weather weather= cacheService.getWeather(city);
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Weather not found for city: " + city, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Weather>> getAll(){
       List<Weather> weatherList= cacheService.getAllWaetherList();
       return new ResponseEntity<>(weatherList,HttpStatus.OK);
    }
    @PutMapping("/updateweather")
    public ResponseEntity<Weather> updateWeather(@RequestBody Weather weather){
        Weather weather1= cacheService.updateweather(weather);
        return new ResponseEntity<>(weather1,HttpStatus.OK);
    }
    @DeleteMapping("/deleteWeather")
    public ResponseEntity<String> deleteWeather(@RequestParam("city") String city){
       int deletedRows= cacheService.deleteWeather(city);
        if (deletedRows == 0) {
            return new ResponseEntity<>("Weather not found for city: " + city, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Weather deleted successfully", HttpStatus.OK);
    }

}

