package com.example.weather.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-api", url = "https://api.openweathermap.org/data/2.5")
public interface WeatherClient {

    @GetMapping(value = "/weather")
    String getPrevisaoAtual(@RequestParam(name = "q") String cidade,
                            @RequestParam String appid,
                            @RequestParam String units,
                            @RequestParam String lang);

    @GetMapping(value = "/forecast")
    String getPrevisao5Dias(@RequestParam(name = "q") String cidade,
                            @RequestParam String appid,
                            @RequestParam String units,
                            @RequestParam String lang);
}
