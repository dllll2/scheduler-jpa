package com.example.schedulerjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseMemberEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    public Member() {
    }

    public Member(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void updatePassword(String password) {
        this.password =password;
    }
}
