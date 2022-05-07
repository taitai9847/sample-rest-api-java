package com.taitai.samplerest.app.todo;

import com.taitai.samplerest.entity.Todo;
import com.taitai.samplerest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RestControllerをつけている場合, @ResponseBodyはつけなくて良い
@RequestMapping("api")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todo")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/todo/{id}")
    public Todo getById(@PathVariable("id") Integer id) {
        return todoService.getById(id);
    }

    @PostMapping("/todo/insert")
    public void insertTodo(@RequestBody Todo todo) {
        Integer id = todo.getId();
        String text = todo.getText();
        Boolean isDone = todo.isDone();
        todoService.insertTodo(id, text, isDone);
        /*
        Postリクエストを送る.
        Bodyの中身は、Todoに合わせる
        ex) curl -X POST -H 'Content-Type:application/json' -d '{"id":6, "text":"test6", "isdone":false}' localhost:8080/api/todo/insert
         */
    }

    @PutMapping("/todo/{id}/update")
    public void updateTodo(@RequestBody @PathVariable("id") Integer id) {
        // 指定したidのタスクのisDoneパラメーターをtrueにする
        todoService.updateTodo(id);
    }

    @DeleteMapping("/todo/{id}/delete")
    public void deleteTodo(@RequestBody @PathVariable("id") Integer id) {
        // 指定したidのタスクを削除する
        todoService.deleteTodo(id);
    }
}
