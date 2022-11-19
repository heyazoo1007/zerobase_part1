package com.example.zerobase_part1.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateDistanceResponse {
    private Double distance;
    private String manageNo;

    @Builder
    public CalculateDistanceResponse(Double distance, String manageNo) {
        this.distance = distance;
        this.manageNo = manageNo;
    }
}
