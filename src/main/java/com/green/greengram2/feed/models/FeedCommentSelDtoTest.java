package com.green.greengram2.feed.models;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class FeedCommentSelDtoTest {
    private List<Integer> ifeeds = new ArrayList<>();
    private int rowCount;
    private int startIdx;
}
