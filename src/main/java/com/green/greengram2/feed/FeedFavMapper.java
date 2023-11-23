package com.green.greengram2.feed;

import com.green.greengram2.feed.models.FeedFavDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavMapper {
    int deleteFav(FeedFavDto dto);
    int insFav(FeedFavDto dto);
}
