package com.weather.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WeatherDaysParametersDto {
    private String date;
    private Integer weatherCode;
    private Double maxTemp;
    private Double minTemp;
    private Double generatedEnergy;

    public WeatherDaysParametersDto(String date, Integer weatherCode, Double maxTemp, Double minTemp, Double generatedEnergy) {
        this.date = date;
        this.weatherCode = weatherCode;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.generatedEnergy = generatedEnergy(generatedEnergy);
    }

    private Double generatedEnergy(Double sunshineDuration) {
        double power = 2.5;
        double panelEfficiency = 0.2;

        return (double) Math.round(sunshineDuration / 3600 * power * panelEfficiency * 1000) / 1000;

    }
}
