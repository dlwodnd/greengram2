package com.green.greengram2.feed.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FeedCommentInsDto {
    private int iuser;
    private int ifeed;
    private String comment;
}
