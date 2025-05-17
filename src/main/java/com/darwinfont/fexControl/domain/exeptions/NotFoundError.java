package com.darwinfont.fexControl.domain.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NotFoundError extends RuntimeException {
    private BodyException body;
    public NotFoundError(String key, String value, String msg) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put(key, value);
        this.body = BodyException.builder()
                .code(1)
                .status(HttpStatus.NOT_FOUND)
                .errors(errors)
                .message(msg)
                .build();
    }
}
