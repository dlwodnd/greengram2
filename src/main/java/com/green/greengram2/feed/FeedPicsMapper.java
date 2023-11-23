package com.green.greengram2.feed;

import com.green.greengram2.feed.models.FeedInsProcDto;
import com.green.greengram2.feed.models.FeedPicVo;
import com.green.greengram2.feed.models.FeedSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicsMapper {
    int insFeedPics(FeedInsProcDto dto);
    List<String> selFeedPicsAll(int ifeed);
    List<FeedPicVo> selFeedPic(List<Integer> ifeedList);
}
