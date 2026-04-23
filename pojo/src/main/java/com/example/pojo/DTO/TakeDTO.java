package com.example.pojo.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class TakeDTO implements Serializable {
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
}