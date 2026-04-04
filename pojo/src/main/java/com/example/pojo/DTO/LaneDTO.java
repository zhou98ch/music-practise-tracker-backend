package com.example.pojo.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class LaneDTO implements Serializable {
    private Long id;
    private Long trackId;
    private String description;
    private Integer order;
}
