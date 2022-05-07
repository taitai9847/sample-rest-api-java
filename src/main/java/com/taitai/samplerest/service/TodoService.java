package com.taitai.samplerest.service;

import com.taitai.samplerest.entity.Todo;
import com.taitai.samplerest.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoService {

    @Autowired
    TodoMapper todoMapper;

    public List<Todo> getAll() {
        return todoMapper.getAll();
    }

    public Todo getById(Integer id) {
        Todo todo = todoMapper.getById(id);
        return todo;
    }

    public void insertTodo(Integer id, String text, Boolean isDone) {
        todoMapper.insertTodo(id, text, isDone);
    }

    public void updateTodo(Integer id) {
        todoMapper.updateTodo(id);
    }

    public void deleteTodo(Integer id) {
        todoMapper.deleteTodo(id);
    }
}
