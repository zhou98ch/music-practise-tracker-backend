package com.example.server.mapper;

import com.example.pojo.entity.Take;
import com.example.server.annotation.AutoFill;
import enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TakeMapper {
    /**
     * insert take
     * @param take
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into take (track_id, lane_id, song_id, description, evaluation, audio_url, start_ms, duration_ms, created_user_id, created_date, updated_date) " +
            "values (#{trackId}, #{laneId}, #{songId}, #{description}, #{evaluation}, #{audioUrl}, #{startMs}, #{durationMs}, #{createdUserId}, #{createdDate}, #{updatedDate})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Take take);

    @Select("select * from take where lane_id = #{laneId} order by start_ms asc")
    List<Take> listByLaneId(@Param("laneId") Long laneId);

}
