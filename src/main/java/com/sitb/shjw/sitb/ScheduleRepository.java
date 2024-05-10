package com.sitb.shjw.sitb;

import com.sitb.shjw.sitb.Dto.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select s from Schedule s where s.user.id=:uid and function('DATEDIFF', s.start_time, :s_date) <= 6")
    List<Schedule> findByUserIdWithConditions(@Param("uid") Long uid, @Param("s_date") Date sDate);
}
