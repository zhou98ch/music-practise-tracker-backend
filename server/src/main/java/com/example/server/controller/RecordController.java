package com.example.server.controller;

import com.example.pojo.DTO.LaneDTO;
import com.example.pojo.entity.Lane;
import com.example.server.service.RecordService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/record")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }
    @PostMapping("/track/{trackId}/createLane")
    public Lane createLane(@RequestBody LaneDTO lane) {
        return recordService.createLane(lane);
    }
}
