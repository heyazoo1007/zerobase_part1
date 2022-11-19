package com.example.zerobase_part1.web.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryRequest {
    private Float x;
    private Float y;
    private LocalDateTime createdTime;

    @Builder
    public HistoryRequest(Float x, Float y, LocalDateTime createdTime) {
        this.x = x;
        this.y = y;
        this.createdTime = createdTime;
    }
}
