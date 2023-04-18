package com.sparta.hanghaememo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class InsertMemoDto {
    private String title;
    private String writer;
    private String password;
    private String content;
}
