package com.example.schedulerjpa.repository;

import com.example.schedulerjpa.dto.TodoPageDto;
import com.example.schedulerjpa.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    default Todo findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    @Query("SELECT new com.example.schedulerjpa.dto.TodoPageDto(" +
            "t.id, t.title, t.contents, m.name, COUNT(c.id)) " +
            "FROM Todo t " +
            "LEFT JOIN t.member m " +
            "LEFT JOIN Comment c ON c.todo = t " +
            "GROUP BY t.id, t.title, t.contents, m.name, t.createdAt, t.modifiedAt " +
            "ORDER BY t.modifiedAt DESC"
    )
    Page<TodoPageDto> findAllWithCommentCount(Pageable pageable);


}
