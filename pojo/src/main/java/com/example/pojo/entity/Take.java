package com.example.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Take implements Serializable {
    private Long id;
    private String trackId;
    private String laneId;
    private String songId;
    private String description;
    private String evaluation;
    private String audioUrl;
    private float startMs;
    private float durationMs;
    private Long createdUserId;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}