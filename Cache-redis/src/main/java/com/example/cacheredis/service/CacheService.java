package com.example.cacheredis.service;

import com.example.cacheredis.entity.Weather;
import com.example.cacheredis.repo.Cacherepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CacheService {
    @Autowired
    Cacherepo cacherepo;

    public  List<Weather> getAllWaetherList() {
       List<Weather> weatherList= cacherepo.findAll();
       return weatherList;

    }

    @Cacheable(value = "weather",key = "#city")
    public  Weather getWeather(String city){
       Weather weather= cacherepo.findWeatherByCity(city);
        return weather;
    }

    public Weather saveWeather(Weather weather) {
      Weather weather1= cacherepo.save(weather);
        return weather1;
    }

    @CachePut(value = "weather",key = "#weather.city")
    public Weather updateweather(Weather weather) {
        Weather existingWeather = cacherepo.findWeatherByCity(weather.getCity());

        if (existingWeather == null) {
            throw new RuntimeException("Weather not found for city: " + weather.getCity());
        }

        existingWeather.setTemperature(weather.getTemperature());
        existingWeather.setWeather(weather.getWeather());

        return cacherepo.save(existingWeather);
    }

    @Transactional
    @CacheEvict(value = "weather",key = "#city")
    public int deleteWeather(String city) {
       return cacherepo.deleteWeatherByCity(city);
    }
}

