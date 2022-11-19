package com.example.zerobase_part1.web.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDistanceFromPublicWifiRequest {
    private Float LAT;
    private Float LNT;

    @Builder
    public GetDistanceFromPublicWifiRequest(Float LAT, Float LNT) {
        this.LAT = LAT;
        this.LNT = LNT;
    }
}
