package com.darwinfont.fexControl.domain.exeptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class BodyException {
    private String message;
    private Map<String, String> errors = new HashMap<>();
    private final int code;
    private final HttpStatus status;
}
