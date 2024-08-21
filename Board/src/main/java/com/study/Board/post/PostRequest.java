package com.study.Board.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    private int bNo;             // PK
    private String bTitle;        // 제목
    private String bContent;      // 내용
    private String bWriter;       // 작성자
    private Boolean bNotice_yn;    // 공지글 여부
}
