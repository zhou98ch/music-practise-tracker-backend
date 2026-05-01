package com.example.server.service;

import com.example.pojo.DTO.TakeDTO;
import com.example.pojo.entity.Take;
import com.example.server.mapper.TakeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TakeService {
    private final TakeMapper takeMapper;
    public Take insertTake(TakeDTO takeDTO) {
        Take take = new Take();
        BeanUtils.copyProperties(takeDTO, take);
        takeMapper.insert(take);
        return take;
    }

    public List<Take> listByLaneId(Long id) {
        return takeMapper.listByLaneId(id);
    }
}
