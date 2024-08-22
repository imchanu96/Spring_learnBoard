package com.study.Board.post;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /*
     *게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public int savePost(final PostRequest params){
        postMapper.save(params);
        return params.getBNo();
    }

    /*
     *게시글 상세정보 조회
     * @param bNo - PK
     * @return 게시글 상세정보
     */
    public PostResponse findPostById(final int bNo){
        return postMapper.findById(bNo);
    }

    /*
     *게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    public int updatePost (final PostRequest params){
        postMapper.update(params);
        return params.getBNo();
    }

    /*
     *게시글 삭제
     * @param bNo - PK
     * @return PK
     */
    public int deletePost(final int bNo){
        postMapper.deleteById(bNo);
        return bNo;
    }

    /*
     *게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<PostResponse> findAllPost(){
        return postMapper.findAll();
    }
}
