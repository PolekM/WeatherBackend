package com.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class Pressure {

    @JsonProperty("surface_pressure")
    private List<Double> pressure;
}
