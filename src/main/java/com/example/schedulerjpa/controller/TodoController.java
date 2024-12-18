package com.example.schedulerjpa.controller;

import com.example.schedulerjpa.dto.*;
import com.example.schedulerjpa.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> save(@RequestBody CreateTodoRequestDto requestDto){
        TodoResponseDto todoResponseDto =
                todoService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getName()
                );

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAll(){
        List<TodoResponseDto> todoResponseDtoList = todoService.findAll();

        return new ResponseEntity<>(todoResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoWithNameResponseDto> findById(@PathVariable Long id){
        TodoWithNameResponseDto todoWithNameResponseDto = todoService.findById(id);

        return new ResponseEntity<>(todoWithNameResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/updateTitle/{id}")
    public ResponseEntity<UpdateTitleRequestDto> updateTitleById(
            @PathVariable Long id,
            @RequestBody UpdateTitleRequestDto requestDto
    ){
        todoService.updateTitleById(id, requestDto.getOldTitle(), requestDto.getNewTitle());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/updateContent/{id}")
    public ResponseEntity<UpdateContentRequestDto> updateContentById(
            @PathVariable Long id,
            @RequestBody UpdateContentRequestDto requestDto
            ){
        todoService.updateContentById(id, requestDto.getOldContent(), requestDto.getNewContent());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        todoService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
