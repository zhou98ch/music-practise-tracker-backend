package com.example.server.mapper;

import com.example.pojo.entity.Song;
import com.example.server.annotation.AutoFill;
import enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;

@Mapper
public interface SongMapper {

    /**
     * insert song
     *
     * @param song
     */
    @Insert("insert into song (name, artist, description, createdUserId, isArchived, isDeleted, isPrivate, createdDate, updatedDate) " +
            "values (#{name}, #{artist}, #{description}, #{createdUserId}, #{isArchived}, #{isDeleted}, #{isPrivate}, #{createdDate}, #{updatedDate})")
    @AutoFill(value = OperationType.INSERT)
    int insert(Song song);

    @Update("update song set isDeleted = 1, updatedDate = #{updatedDate} where id = #{id}")
    void deletebyID(Long id, LocalDate updatedDate);
     @Update("update song set name = #{name}, artist = #{artist}, description = #{description}, isArchived = #{isArchived}, isPrivate = #{isPrivate}, updatedDate = #{updatedDate} where id = #{id}")
     @AutoFill(value = OperationType.UPDATE)
     void update(Song song);

    @Select("select * from song where id=#{id}")
    Song selectById(Long id);

    /**
     * list songs by category id
     *
     * @param category_id
     * @return
     */
    @Select("select * from song where categoryId=#{category_id} order by createdDate desc")
    Object listByCategory(Long category_id);
}
