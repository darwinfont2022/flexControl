package com.darwinfont.fexControl.domain.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto<T> {
    Boolean empty = true;
    Integer pages = 0;
    Integer totalElements = 0;
    List<T> items = new ArrayList<>();
    Integer size = 0;
    Boolean sorted = false;
}
