package com.green.greengram2.feed.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class FeedSelDto {
    private int loginedIuser;
    private int targetIuser;

    private int startIdx;
    private int rowCount;
}
