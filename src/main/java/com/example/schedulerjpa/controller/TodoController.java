package com.example.schedulerjpa.controller;

import com.example.schedulerjpa.dto.*;
import com.example.schedulerjpa.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> save(
            @Validated @RequestBody CreateTodoRequestDto requestDto,
            BindingResult bindingResult){

        log.info("Controller 호출");

        if(bindingResult.hasErrors()){
            log.info("validation errors={}", bindingResult);
            return (ResponseEntity<TodoResponseDto>) bindingResult.getAllErrors();
        }

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

    @GetMapping("/todos")
    public Page<TodoPageDto> getTodos(
            @RequestParam(defaultValue = "0") int page,    // 페이지 번호
            @RequestParam(defaultValue = "10") int size    // 페이지 크기
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return todoService.getTodosWithPaging(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoWithNameResponseDto> findById(@PathVariable Long id){
        TodoWithNameResponseDto todoWithNameResponseDto = todoService.findById(id);

        return new ResponseEntity<>(todoWithNameResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/updateTitle/{id}")
    public ResponseEntity<UpdateTitleRequestDto> updateTitleById(
            @PathVariable Long id,
            @Validated @RequestBody UpdateTitleRequestDto requestDto,
            BindingResult bindingResult
    ){

        log.info("Controller 호출");

        if(bindingResult.hasErrors()){
            log.info("validation errors={}", bindingResult);
            return (ResponseEntity<UpdateTitleRequestDto>) bindingResult.getAllErrors();
        }
        todoService.updateTitleById(id, requestDto.getOldTitle(), requestDto.getNewTitle());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/updateContent/{id}")
    public ResponseEntity<UpdateContentRequestDto> updateContentById(
            @PathVariable Long id,
            @Validated @RequestBody UpdateContentRequestDto requestDto,
            BindingResult bindingResult
            ){

        log.info("Controller 호출");

        if(bindingResult.hasErrors()){
            log.info("validation errors={}", bindingResult);
            return (ResponseEntity<UpdateContentRequestDto>) bindingResult.getAllErrors();
        }
        todoService.updateContentById(id, requestDto.getOldContent(), requestDto.getNewContent());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        todoService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
