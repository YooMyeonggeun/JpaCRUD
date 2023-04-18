package com.sparta.hanghaememo.entity;

import com.sparta.hanghaememo.dto.InsertMemoDto;
import com.sparta.hanghaememo.dto.MemoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;

    public Memo(MemoRequestDto requestDto){
        this.title = "제목없음";
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        password = "1234";
    }

    public void update(MemoRequestDto requestDto) {
        this.title = "제목없음";
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        password = "1234";
    }

    public void Insert(InsertMemoDto insertMemoDto){
//        this.title = insertMemoDto.getTitle(); // 제목
//        this.username = insertMemoDto.getWriter(); // 작성자
//        this.contents = insertMemoDto.getContent(); // 내용
//        this.password = insertMemoDto.getPassword(); // 비밀번호
        this.title = "title2";
        this.username = "writer";
        this.contents = "content";
        this.password = "1234";
    }


//    public InsertMemoDto choseMemo(Long num){
//        this.title
//    }

}