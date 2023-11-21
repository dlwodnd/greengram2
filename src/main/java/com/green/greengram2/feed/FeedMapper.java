package com.green.greengram2.feed;

import com.green.greengram2.ResVo;
import com.green.greengram2.feed.models.FeedInsDto;
import com.green.greengram2.feed.models.FeedInsProcDto;
import com.green.greengram2.feed.models.FeedSelDto;
import com.green.greengram2.feed.models.FeedSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);


    List<FeedSelVo> selFeedAll(FeedSelDto dto);
}
