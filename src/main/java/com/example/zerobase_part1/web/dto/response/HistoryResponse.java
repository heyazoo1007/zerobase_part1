package com.example.zerobase_part1.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryResponse {

    private Integer id;
    private Float x;
    private Float y;
    private String createdTime;

    @Builder
    public HistoryResponse(Integer id, Float x, Float y, String createdTime) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.createdTime = createdTime;
    }
}
