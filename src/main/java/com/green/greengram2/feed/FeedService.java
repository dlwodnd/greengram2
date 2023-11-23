package com.green.greengram2.feed;

import com.green.greengram2.ResVo;
import com.green.greengram2.feed.models.*;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicsMapper picsMapper;
    private final FeedFavMapper favMapper;
    private final FeedCommentMapper commentMapper;

    public ResVo postFeed(FeedInsDto dto) {
        if (dto.getPics().size() == 0) {
            return new ResVo(2); //사진이 하나도 없음
        }
        FeedInsProcDto pDto = FeedInsProcDto.builder()
                .iuser(dto.getIuser())
                .contents(dto.getContents())
                .location(dto.getLocation())
                .pics(dto.getPics())
                .build();
        int feedAffectedRows = mapper.insFeed(pDto);
        if (feedAffectedRows == 0 || pDto.getIfeed() == 0) {
            return new ResVo(0);
        }
        int feedPicsAffectedRows = picsMapper.insFeedPics(pDto);
        if (feedPicsAffectedRows != dto.getPics().size()) { //트랜잭션이면 rollback
            return new ResVo(3); //사진 등록이 제대로 안 됨.
        }
        return new ResVo(pDto.getIfeed());
    }

    //N+1 허용
    public List<FeedSelVo> getFeedAll(FeedSelDto dto) {
        List<FeedSelVo> list = mapper.selFeedAll(dto);

        for (FeedSelVo vo : list) {
            List<String> pics = picsMapper.selFeedPicsAll(vo.getIfeed());
            vo.setPics(pics);
            List<FeedCommentSelVo> comments = commentMapper.selCommentAll(FeedCommentSelDto.builder()
                                                                        .ifeed(vo.getIfeed())
                                                                        .startIdx(0)
                                                                        .rowCount(4)
                                                                        .build());

            if(comments.size() == 4){
                vo.setIsMoreComment(1);
                comments.remove(comments.size() - 1);
            }
            vo.setComments(comments);
        }
        return list;
    }
    public List<FeedSelVo> getFeedAllTest(FeedSelDto dto){
        List<FeedSelVo> voList = mapper.selFeedAll(dto);
        List<Integer> ifeedList = new ArrayList<>();
        Map<Integer,FeedSelVo> voMap = new HashMap<>();
        for(FeedSelVo vo : voList){
            ifeedList.add(vo.getIfeed());
            voMap.put(vo.getIfeed(),vo);
        }
        if(ifeedList.size() > 0){
            List<FeedPicVo> picVoList = picsMapper.selFeedPic(ifeedList);
            for(FeedPicVo vo : picVoList){
                FeedSelVo selVo = voMap.get(vo.getIfeed());
                selVo.getPics().add(vo.getPic());
            }
        }
        return voList;
    }
    public ResVo toggleFeedFav(FeedFavDto dto){
        int result = favMapper.deleteFav(dto);
        if(result == 0){
            favMapper.insFav(dto);
            return new ResVo(1);
        }
        return new ResVo(0);
    }
    public ResVo insComment(FeedCommentInsDto dto){
        FeedCommentInsProcDto pDto = new FeedCommentInsProcDto(dto);
        int affectedRows = commentMapper.insComment(pDto);
        return new ResVo(pDto.getIfeedComment());
    }
    public List<FeedCommentSelVo> getCommentAll(int ifeed){
        return commentMapper.selCommentAll(FeedCommentSelDto.builder()
                        .ifeed(ifeed)
                        .startIdx(4)
                        .rowCount(9999999)
                        .build());
    }
    public ResVo delComment(FeedCommentDelDto dto){
        int result = commentMapper.delLoginedUserComment(dto);
        return new ResVo(result);
    }
    public ResVo delFeed(FeedDelDto dto){
        if(mapper.selIuser(dto) == dto.getIuser()){
            mapper.delFeedByFav(dto);
            mapper.delFeedByComment(dto);
            mapper.delFeedByPics(dto);
            mapper.delFeedByFeed(dto);
            return new ResVo(1);
        }
        return new ResVo(0);
    }
}
