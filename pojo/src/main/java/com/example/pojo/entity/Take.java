package com.example.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Take implements Serializable {
    private Long id;
    private Long trackId;
    private Long laneId;
    private Long songId;
    private String description;
    private String evaluation;
    private String audioUrl;
    private Long startMs;
    private Long durationMs;
    private Long createdUserId;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}