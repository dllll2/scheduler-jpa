package com.example.schedulerjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment() {
    }

    public Comment(String contents, Member member, Todo todo) {
        this.contents = contents;
        this.member = member;
        this.todo = todo;
    }

    public void update(String contents) {
        this.contents = contents;
    }
}
