package com.weather.exception;

import lombok.Data;

@Data
public class Error {

    private Integer code;
    private String message;
}
