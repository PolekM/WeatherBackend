package com.weather.Controller;

import com.weather.Dto.WeatherWeekResponse;
import com.weather.Dto.WeatherWeekSummaryResponse;
import com.weather.Service.WeatherService;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/weather")
@Validated
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/week")
    public WeatherWeekResponse getWeekWeather(@RequestParam(name="latitude")
                                                  @NotNull(message = "Latitude cannot be null")
                                                  @DecimalMin(value = "-90.0", message = "Latitude must be greater than or equal to -90")
                                                  @DecimalMax(value = "90.0", message = "Latitude must be less than or equal to 90")
                                                  Double latitude,
                                                  @RequestParam(name = "longitude")
                                                  @NotNull(message = "Longitude cannot be null")
                                                  @DecimalMin(value = "-180.0", message = "Longitude must be greater than or equal to -180")
                                                  @DecimalMax(value = "180.0", message = "Longitude must be less than or equal to 180")Double longitude){
        return weatherService.getWeekWeather(latitude,longitude);
    }

    @GetMapping("/summary")
    public WeatherWeekSummaryResponse getWeekSummary(@RequestParam(name="latitude")
                                                         @NotNull(message = "Latitude cannot be null")
                                                         @DecimalMin(value = "-90.0", message = "Latitude must be greater than or equal to -90")
                                                         @DecimalMax(value = "90.0", message = "Latitude must be less than or equal to 90")
                                                         Double latitude,
                                                     @RequestParam(name = "longitude")
                                                         @NotNull(message = "Longitude cannot be null")
                                                         @DecimalMin(value = "-180.0", message = "Longitude must be greater than or equal to -180")
                                                         @DecimalMax(value = "180.0", message = "Longitude must be less than or equal to 180")Double longitude){
        return weatherService.getWeekSummary(latitude,longitude);
    }

}
