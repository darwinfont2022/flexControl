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
public class ConflictError extends RuntimeException {
    private BodyException body;

    public ConflictError(String key, String value, String msg) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put(key, value);
        this.body = BodyException.builder()
                .code(0)
                .status(HttpStatus.CONFLICT)
                .errors(errors)
                .message(msg)
                .build();
    }
}
