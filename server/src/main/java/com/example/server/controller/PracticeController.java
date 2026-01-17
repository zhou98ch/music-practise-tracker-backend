package com.example.server.controller;

import com.example.pojo.DTO.PracticeTimeRequestDTO;
import com.example.pojo.entity.PracticeTimeRecord;
//import com.example.server.repository.PracticeTimeRecordRepository;
import com.example.server.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/practice")
public class PracticeController {

//    private final PracticeTimeRecordRepository practiceRepository;
    private final RecordService recordService;
    @Autowired
    public PracticeController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/savePracticeRecord")
    @CrossOrigin(origins = "*",
            allowedHeaders = "*",
            exposedHeaders = "*")  // Add this line
    public List<PracticeTimeRecord> savePracticeRecords(@RequestBody List<PracticeTimeRequestDTO> dtos) {
        System.out.println("Saving multiple records: " + dtos.size());

        return dtos.stream().map(dto -> {
            PracticeTimeRecord record = new PracticeTimeRecord();
            record.setMusicId(dto.getMusicId());
            record.setBpm(dto.getBpm());
            record.setDuration(dto.getDuration());
            record.setDate(LocalDate.now());
            record.setUserId("current_user_id");
            record.setUpdatedAt(LocalDate.now());
            System.out.println("Processing record: " + dto);
            return recordService.createRecord(record);
        }).toList();
    }
    @PostMapping("/batch")
    public RecordService.BatchResult sync(@RequestBody List<PracticeTimeRecord> records) {
        return recordService.sync(records);
    }

//    @GetMapping
//    public List<PracticeTimeRecord> getAllPracticeRecords() {
//        return practiceRepository.findAll();
//    }
}
