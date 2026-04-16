package com.example.pojo.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class TakeDTO implements Serializable {
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
}