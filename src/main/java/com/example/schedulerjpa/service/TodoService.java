package com.example.schedulerjpa.service;

import com.example.schedulerjpa.dto.TodoResponseDto;
import com.example.schedulerjpa.dto.TodoWithNameResponseDto;
import com.example.schedulerjpa.entity.Member;
import com.example.schedulerjpa.entity.Todo;
import com.example.schedulerjpa.repository.MemberRepository;
import com.example.schedulerjpa.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final MemberRepository memberRepository;
    private final TodoRepository todoRepository;
    public TodoResponseDto save(String title, String contents, String name) {
        Member findMember = memberRepository.findMemberByNameOrElseThrow(name);
        Todo todo = new Todo(title, contents);
        todo.setMember(findMember);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents());

    }

    public Page<TodoResponseDto> findAll(Pageable pageable) {
        return todoRepository.findAllByOrderByModifiedAtDesc(pageable)
                .map(TodoResponseDto::toDto);
    }





    public TodoWithNameResponseDto findById(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);
        Member Writer = findTodo.getMember();

        return new TodoWithNameResponseDto(findTodo.getTitle(), findTodo.getContents(), Writer.getName());
    }

    @Transactional
    public void updateTitleById(Long id, String oldTitle, String newTitle) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        if (!findTodo.getTitle().equals(oldTitle)) { // 제목이 수정되지 않은 경우
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정된 제목이 기존 제목과 동일합니다.");
        }

        findTodo.updateTitleById(newTitle);

    }

    @Transactional
    public void updateContentById(Long id, String oldContent, String newContent) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        if (!findTodo.getContents().equals(oldContent)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정된 내용이 기존 내용과 동일합니다.");
        }

        findTodo.updateContentById(newContent);
    }

    public void delete(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        todoRepository.delete(findTodo);
    }
}
