package com.example.server.controller;

import com.example.pojo.DTO.TakeDTO;
import com.example.pojo.entity.Take;
import com.example.result.Result;
import com.example.server.service.TakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/take")
public class TakeController {
    private final TakeService takeService;

    public TakeController(TakeService takeService) {
        this.takeService = takeService;
    }
    @PostMapping("/insert")
    public Result<Take> insertTake(@RequestBody TakeDTO take) {
        return Result.success(takeService.insertTake(take));
    }

    @GetMapping("/lane/{laneId}")
    public Result<List<Take>> listByLaneId(@PathVariable Long laneId) {
        return Result.success(takeService.listByLaneId(laneId));
    }
}
