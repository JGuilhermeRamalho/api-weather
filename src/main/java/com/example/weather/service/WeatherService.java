package com.example.weather.service;

import com.example.weather.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private WeatherClient weatherClient;

    @Value("${weather.api.key}")
    private String API_KEY;

    private static final String UNITS = "metric";
    private static final String LANG = "pt";

    //private final RestTemplate restTemplate = new RestTemplate();

    public String getPrevisaoAtual(String cidade) {

        return weatherClient.getPrevisaoAtual(cidade, API_KEY, UNITS, LANG);

        //String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cidade + "&appid=" + apiKey + "&units=metric&lang=pt";
        //return restTemplate.getForObject(url, String.class);

    }

    public String getPrevisao5Dias(String cidade) {

        return weatherClient.getPrevisao5Dias(cidade, API_KEY, UNITS, LANG);

        //String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + cidade + "&appid=" + apiKey + "&units=metric&lang=pt";
        //return restTemplate.getForObject(url, String.class);

    }


}
