package com.weather.Service.imp;

import com.weather.Dto.WeatherDaysParametersDto;
import com.weather.Dto.WeatherWeekResponse;
import com.weather.Dto.WeatherWeekSummaryResponse;
import com.weather.Service.WeatherService;
import com.weather.exception.ApiException;
import com.weather.model.PressureHolder;
import com.weather.model.Weather;
import com.weather.model.WeatherHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class WeatherServiceImp implements WeatherService {


    private final RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherWeekResponse getWeekWeather(Double latitude, Double longitude) {
        WeatherHolder weatherHolder = getWeather(latitude, longitude);
        Weather weather = weatherHolder.getWeather();
        List<WeatherDaysParametersDto> weatherDaysParametersDto = new ArrayList<>();
        for (int i = 0; i < weather.getTime().size(); i++) {
            weatherDaysParametersDto.add(new WeatherDaysParametersDto(weather.getTime().get(i)
                    , weather.getWeatherCode().get(i)
                    , weather.getMaxTemp().get(i)
                    , weather.getMinTemp().get(i)
                    , weather.getSunshineDuration().get(i)));
        }

        return new WeatherWeekResponse(weatherDaysParametersDto);
    }

    @Override
    public WeatherWeekSummaryResponse getWeekSummary(Double latitude, Double longitude) {
        WeatherHolder weekWeather = getWeather(latitude, longitude);
        PressureHolder pressure = getPressure(latitude, longitude);
        return new WeatherWeekSummaryResponse(pressure.getPressure(), weekWeather.getWeather());
    }

    public WeatherHolder getWeather(Double latitude, Double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&daily=weather_code,temperature_2m_max,temperature_2m_min,sunshine_duration";
        try {
            return restTemplate.getForObject(url, WeatherHolder.class);
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }

    }

    public PressureHolder getPressure(Double latitude, Double longitude) {
        String pressureUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=surface_pressure";
        try {
            return restTemplate.getForObject(pressureUrl, PressureHolder.class);
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }
}
