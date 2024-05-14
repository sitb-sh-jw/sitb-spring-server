package com.sitb.shjw.sitb.Controller;

import com.sitb.shjw.sitb.Dto.*;
import com.sitb.shjw.sitb.ScheduleRepository;
import com.sitb.shjw.sitb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/week/{s_date}")
    public ScheduleWeekResponse getWeekScheduleByUserId(@RequestHeader("uid") Long uid, @PathVariable("s_date") String stringDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate;
        try {
            sDate = sdf.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<Schedule> scheduleList = scheduleRepository.findByUserIdWithConditions(uid, sDate);
        for (int i = 0; i < scheduleList.size(); i++) {
            System.out.println(scheduleList.get(i));
        }

        if (scheduleList == null || scheduleList.isEmpty()) {
            return null;
        }
        else {
            ScheduleWeekResponse scheduleWeekResponse = new ScheduleWeekResponse();

            for (Schedule schedule : scheduleList) {
                Category category = schedule.getCategory();
                ScheduleResponse scheduleResponse = new ScheduleResponse(schedule.getTitle(), category.getName(), category.getColor(), schedule.getStart_time(), schedule.getEnd_time(), schedule.getLocation(), schedule.getMemo());
                System.out.println(scheduleResponse);
                System.out.println(schedule.getStart_time().getDay());
                System.out.println(sDate.getDay());
                if (schedule.getStart_time().getDay() == sDate.getDay()) {
                    System.out.println("monday");
                    List<ScheduleResponse> mondayScheduleList = scheduleWeekResponse.getMonday();
                    if (mondayScheduleList == null || mondayScheduleList.isEmpty()) {
                        mondayScheduleList = new ArrayList<>();
                    }
                    mondayScheduleList.add(scheduleResponse);
                    scheduleWeekResponse.setMonday(mondayScheduleList);
                } else if (schedule.getStart_time().getDay() == sDate.getDay()+1) {
                    System.out.println("tuesday");
                    List<ScheduleResponse> tuesdayScheduleList = scheduleWeekResponse.getTuesday();
                    if (tuesdayScheduleList == null || tuesdayScheduleList.isEmpty()) {
                        tuesdayScheduleList = new ArrayList<>();
                    }
                    tuesdayScheduleList.add(scheduleResponse);
                    scheduleWeekResponse.setTuesday(tuesdayScheduleList);
                } else if (schedule.getStart_time().getDay() == sDate.getDay()+2) {
                    System.out.println("wednesday");
                    List<ScheduleResponse> wednesdayScheduleList = scheduleWeekResponse.getWednesday();
                    if (wednesdayScheduleList == null || wednesdayScheduleList.isEmpty()) {
                        wednesdayScheduleList = new ArrayList<>();
                    }
                    wednesdayScheduleList.add(scheduleResponse);
                    scheduleWeekResponse.setWednesday(wednesdayScheduleList);
                } else if (schedule.getStart_time().getDay() == sDate.getDay()+3) {
                    System.out.println("thursday");
                    List<ScheduleResponse> thursdayScheduleList = scheduleWeekResponse.getThursday();
                    if (thursdayScheduleList == null || thursdayScheduleList.isEmpty()) {
                        thursdayScheduleList = new ArrayList<>();
                    }
                    thursdayScheduleList.add(scheduleResponse);
                    scheduleWeekResponse.setThursday(thursdayScheduleList);
                } else if (schedule.getStart_time().getDay() == sDate.getDay()+4) {
                    System.out.println("friday");
                    List<ScheduleResponse> fridayScheduleList = scheduleWeekResponse.getFriday();
                    if (fridayScheduleList == null || fridayScheduleList.isEmpty()) {
                        fridayScheduleList = new ArrayList<>();
                    }
                    fridayScheduleList.add(scheduleResponse);
                    scheduleWeekResponse.setFriday(fridayScheduleList);
                } else if (schedule.getStart_time().getDay() == sDate.getDay()+5) {
                    System.out.println("saturday");
                    List<ScheduleResponse> saturdayScheduleList = scheduleWeekResponse.getSaturday();
                    if (saturdayScheduleList == null || saturdayScheduleList.isEmpty()) {
                        saturdayScheduleList = new ArrayList<>();
                    }
                    saturdayScheduleList.add(scheduleResponse);
                    scheduleWeekResponse.setSaturday(saturdayScheduleList);
                } else if (schedule.getStart_time().getDay() == sDate.getDay()+6) {
                    System.out.println("sunday");
                    List<ScheduleResponse> sundayScheduleList = scheduleWeekResponse.getSunday();
                    if (sundayScheduleList == null || sundayScheduleList.isEmpty()) {
                        sundayScheduleList = new ArrayList<>();
                    }
                    sundayScheduleList.add(scheduleResponse);
                    scheduleWeekResponse.setSunday(sundayScheduleList);
                }
                System.out.println(scheduleWeekResponse);
            }
            return scheduleWeekResponse;
        }
    }
}
