package com.sitb.shjw.sitb.Dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "schedule")
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date start_time;
    private Date end_time;
    private String Location;
    private String memo;

    @ManyToOne // Many = Board, User = One 한명의 유저는 여러개의 게시글을 쓸 수 있다.
    @JoinColumn(name="uid") // foreign key (userId) references User (id)
    private User user;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    @Override
    public String toString() {
        return id.toString() + " " + title + " " + start_time + " " + end_time + " " + Location + " " + memo;
    }
}

