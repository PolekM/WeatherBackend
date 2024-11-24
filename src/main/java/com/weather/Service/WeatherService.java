package com.weather.Service;

import com.weather.Dto.WeatherWeekResponse;
import com.weather.Dto.WeatherWeekSummaryResponse;

public interface WeatherService {
    WeatherWeekResponse getWeekWeather(Double latitude, Double longitude);

    WeatherWeekSummaryResponse getWeekSummary(Double latitude, Double longitude);
}
