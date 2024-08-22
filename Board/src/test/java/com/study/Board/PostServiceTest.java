package com.study.Board;

import com.study.Board.post.PostRequest;
import com.study.Board.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save(){
        PostRequest params = new PostRequest();
        params.setBTitle("1번 게시글 제목");
        params.setBContent("1번 게시글 내용");
        params.setBWriter("테스터");
        params.setBNotice_yn(false);
        int id = postService.savePost(params);
        System.out.println("생성된 게시글 ID : " + id);
    }
}
