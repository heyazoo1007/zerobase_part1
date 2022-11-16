package com.example.zerobase_part1.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryDto {
    private Float x;
    private Float y;
    private LocalDateTime createdTime;

    public HistoryDto(Float x, Float y, LocalDateTime createdTime) {
        this.x = x;
        this.y = y;
        this.createdTime = createdTime;
    }
}
