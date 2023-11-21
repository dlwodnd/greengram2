package com.green.greengram2.feed.models;

import lombok.Data;

import java.util.List;

@Data
public class FeedInsDto {
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;
}
