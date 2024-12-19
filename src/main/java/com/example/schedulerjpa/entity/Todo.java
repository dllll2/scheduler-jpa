package com.example.schedulerjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column
    private Integer commentCount = 0;

    public Todo() {
    }

    public Todo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setMember(Member member){
        this.member = member;
    }

    public void updateTitleById(String title) {
        this.title = title;
    }

    public void updateContentById(String contents){
        this.contents = contents;
    }
}
