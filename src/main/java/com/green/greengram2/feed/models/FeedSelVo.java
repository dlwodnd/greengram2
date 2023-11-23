package com.green.greengram2.feed.models;

import lombok.Data;

import java.util.List;

@Data
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private String createdAt;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
    private int isFav; //1:좋아요, 0:아님
    private List<String> pics;
    private List<FeedCommentSelVo> comments;
    private int isMoreComment;
}
