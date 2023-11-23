package com.green.greengram2.feed;

import com.green.greengram2.ResVo;
import com.green.greengram2.feed.models.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);


    List<FeedSelVo> selFeedAll(FeedSelDto dto);
    int selIuser(FeedDelDto dto);
    int delFeedByFav(FeedDelDto dto);
    int delFeedByFeed(FeedDelDto dto);
    int delFeedByComment(FeedDelDto dto);
    int delFeedByPics(FeedDelDto dto);
}
