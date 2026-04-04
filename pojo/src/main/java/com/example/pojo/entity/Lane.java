package com.example.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Lane implements Serializable {
    private Long id;
    private Long trackId;
    private String description;
    private Integer order;
}
