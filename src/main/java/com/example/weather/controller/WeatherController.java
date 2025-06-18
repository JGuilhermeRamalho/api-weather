package com.example.weather.controller;

import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{cidade}")
    public ResponseEntity<String> getPrevisao(@PathVariable String cidade) {

        return ResponseEntity.ok(weatherService.getPrevisaoAtual(cidade));

    }

    @GetMapping("/5dias/{cidade}")
    public ResponseEntity<String> getPrevisao5Dias(@PathVariable String cidade) {
        return ResponseEntity.ok(weatherService.getPrevisao5Dias(cidade));
    }

}
