package com.green.greengram2.feed.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class FeedInsProcDto {
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;

}
