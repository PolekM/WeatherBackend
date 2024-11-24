package com.weather.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class WeatherWeekResponse {

    private List<WeatherDaysParametersDto> weatherDays;


    public WeatherWeekResponse(List<WeatherDaysParametersDto> weatherDays) {
        this.weatherDays = weatherDays;
    }
}
