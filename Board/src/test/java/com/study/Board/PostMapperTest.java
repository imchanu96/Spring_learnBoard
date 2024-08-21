package com.study.Board;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.Board.post.PostMapper;
import com.study.Board.post.PostRequest;
import com.study.Board.post.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setBTitle("100번 게시글 제목");
        params.setBContent("100번 게시글 내용");
        params.setBWriter("100테스터");
        params.setBNotice_yn(false);

        postMapper.save(params);

        List<PostResponse> posts = postMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }

    @Test
    void findById() {
        PostResponse post = postMapper.findById(3);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void update() {
        // 1. 게시글 수정
        PostRequest params = new PostRequest();
        params.setBNo(1);
        params.setBTitle("1번 게시글 제목 수정합니다.");
        params.setBContent("1번 게시글 내용 수정합니다.");
        params.setBWriter("임찬우");
        params.setBNotice_yn(true);
        postMapper.update(params);

        // 2. 게시글 상세정보 조회
        PostResponse post = postMapper.findById(1);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete() {
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
        postMapper.deleteById(1);
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
    }
}
