package com.example.pojo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PracticeTimeRecord {
    private Long id;
    private String userId;
    private String musicId;
    private String recordId; // client-generated UUID，for idempotent synchronization
    private Integer bpm;
    private Long duration; // counted in seconds
    private LocalDate date;
    private LocalDate updatedAt; // TODO Migrate to LocalDateTime
}
// TODO: needs to change parameter names to adapt to the Autofill rules