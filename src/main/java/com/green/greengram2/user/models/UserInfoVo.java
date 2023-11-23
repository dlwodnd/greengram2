package com.green.greengram2.user.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoVo {
    private int feedCnt;//작성한 총 게시글
    private int favCnt;//받은 총 좋아요 수
    private String nm;
    private String createdAt;//가입날짜
    private String pic;
}
