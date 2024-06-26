package com.sitb.shjw.sitb.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScheduleWeekResponse {
    private List<ScheduleResponse> monday;
    private List<ScheduleResponse> tuesday;
    private List<ScheduleResponse> wednesday;
    private List<ScheduleResponse> thursday;
    private List<ScheduleResponse> friday;
    private List<ScheduleResponse> saturday;
    private List<ScheduleResponse> sunday;

    @Override
    public String toString() {
        return "ScheduleWeekResponse [monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday + "]";
    }
}
