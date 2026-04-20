package com.example.server.service;

import com.example.pojo.DTO.LaneDTO;
import com.example.pojo.entity.Lane;
import com.example.pojo.entity.PracticeTimeRecord;
import com.example.server.mapper.PractiseTimeRecordMapper;
import com.example.server.mapper.RecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordMapper recordMapper;
    public Lane createLane(LaneDTO laneDTO) {
        Lane lane = new Lane();
        BeanUtils.copyProperties(laneDTO, lane);
        recordMapper.insertLane(lane);
        return lane;
    }

}
