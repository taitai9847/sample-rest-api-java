package com.taitai.samplerest.mapper;

import com.taitai.samplerest.entity.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todo")
    public List<Todo> getAll();

    @Select("SELECT * FROM todo WHERE id = #{id}")
    public Todo getById(@Param("id") Integer id);

    @Insert("INSERT INTO todo (id, text, isDone) VALUES (#{id}, #{text}, #{isDone})")
    public void insertTodo(@Param("id") Integer id, @Param("text") String text, @Param("isDone") Boolean isDone);

    @Update("UPDATE todo SET isdone = true WHERE id = #{id}")
    public void updateTodo(@Param("id") Integer id);

    @Delete("DELETE FROM todo WHERE id = #{id}")
    public  void deleteTodo(@Param("id") Integer id);

}
