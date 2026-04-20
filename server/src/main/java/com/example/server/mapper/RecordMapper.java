package com.example.server.mapper;

import com.example.pojo.DTO.UserPageQueryDTO;
import com.example.pojo.entity.Lane;
import com.example.pojo.entity.User;
import com.example.server.annotation.AutoFill;
import enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {
    /**
     * insert lane
     * @param lane
     */
    @Insert("insert into lane (track_id, description, sort_order) " +
            "values (#{trackId}, #{description}, #{order})")
    @AutoFill(value = OperationType.INSERT)
    void insertLane(Lane lane);

}
