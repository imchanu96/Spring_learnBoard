package com.study.Board.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private int bNo;                       // PK
    private String bTitle;                  // 제목
    private String bContent;                // 내용
    private String bWriter;                 // 작성자
    private int bViewCnt;                   // 조회 수
    private Boolean bNotice_yn;              // 공지글 여부
    private Boolean bDelete_yn;              // 삭제 여부
    private LocalDateTime bCreated_date;     // 생성일시
    private LocalDateTime bModified_date;    // 최종 수정일시
}
