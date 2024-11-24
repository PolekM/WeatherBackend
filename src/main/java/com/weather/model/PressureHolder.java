package com.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PressureHolder {

    @JsonProperty("hourly")
    private Pressure pressure;
}
