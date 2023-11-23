package com.green.greengram2.feed;

import com.green.greengram2.feed.models.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedCommentMapper {
    int insComment(FeedCommentInsProcDto pDto);

    List<FeedCommentSelVo> selCommentAll(FeedCommentSelDto dto);

    int delLoginedUserComment(FeedCommentDelDto dto);
}
