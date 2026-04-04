package com.example.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Track implements Serializable {
    private Long id;
    private String description;
    private LocalDate createdDate;
}
