package com.weather.Dto;

import com.weather.model.Pressure;
import com.weather.model.Weather;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class WeatherWeekSummaryResponse {

    private Double averagePressure;
    private Double averageSunshineDuration;
    private Double minTemperature;
    private Double maxTemperature;
    private String GeneralWeatherSummary;

    public WeatherWeekSummaryResponse(Pressure pressure, Weather weather) {
        this.averagePressure = getAverageWeeklyPressure(pressure.getPressure());
        this.averageSunshineDuration = getAverageWeeklySunriseDuration(weather.getSunshineDuration());
        this.minTemperature = weather.getMinTemp().stream().min(Double::compareTo).get();
        this.maxTemperature = weather.getMaxTemp().stream().max(Double::compareTo).get();
        this.GeneralWeatherSummary = GetWeatherSummary(weather.getWeatherCode());
    }

    public String GetWeatherSummary(List<Integer> weatherCodes) {
        int flag = 0;
        for (Integer weatherCode : weatherCodes) {
            if (weatherCode < 51) {
                flag++;
            }
        }
        return flag > 4 ? "not rainy " : "rainy";
    }

    public Double getAverageWeeklySunriseDuration(List<Double> sunshineDurationList) {
        if (sunshineDurationList.isEmpty()) {
            return 0.0;
        }
        double sum = sunshineDurationList.stream().mapToDouble(Double::doubleValue).sum();
        return (double) Math.round(sum/3600 / sunshineDurationList.size() * 100.0) / 100.0;
    }

    public Double getAverageWeeklyPressure(List<Double> pressureList) {
        if (pressureList.isEmpty()) {
            return 0.0;
        }
        double sum = pressureList.stream().mapToDouble(Double::doubleValue).sum();
        return (double) Math.round(sum / pressureList.size() * 100.0) / 100.0;
    }
}
