package com.sitb.shjw.sitb.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ScheduleResponse {
    private String title;
    private String category;
    private String category_color;
    private Date start_time;
    private Date end_time;
    private String location;
    private String memo;

    public ScheduleResponse(String title, String name, String color, Date startTime, Date endTime, String location, String memo) {
        this.title = title;
        this.category = name;
        this.category_color = color;
        this.start_time = startTime;
        this.end_time = endTime;
        this.location = location;
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "ScheduleResponse [title=" + title + ", category=" + category + ", category_color=" + category_color + ", start_time=" + start_time + ", end_time=" + end_time + ", location=" + location + ", memo=" + memo + "]";
    }
}
