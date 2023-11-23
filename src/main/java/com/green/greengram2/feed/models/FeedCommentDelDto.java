package com.green.greengram2.feed.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedCommentDelDto {
    private int ifeedComment;
    private int loginedIuser;
}
