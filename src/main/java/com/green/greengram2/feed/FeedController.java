package com.green.greengram2.feed;

import com.green.greengram2.ResVo;
import com.green.greengram2.feed.models.FeedInsDto;
import com.green.greengram2.feed.models.FeedInsProcDto;
import com.green.greengram2.feed.models.FeedSelDto;
import com.green.greengram2.feed.models.FeedSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
@Tag(name = "피드",description = "피드관련 처리")
@Slf4j
public class FeedController {
    private final FeedService service;


    @PostMapping
    @Operation(summary = "게시글 작성",description = "게시글 작성")
    @Parameters(value = {
            @Parameter(name = "iuser", description = "유저pk값")
            ,@Parameter(name = "contents", description = "게시글 내용")
            ,@Parameter(name = "location", description = "장소")
            ,@Parameter(name = "pics", description = "사진(여러장가능)")
    })
    public ResVo postFeed(@RequestBody FeedInsDto dto) {

        return service.postFeed(dto);
    }
    @GetMapping
    public List<FeedSelVo> getFeedAll(int page, int loginedIuser,
                                      @RequestParam(defaultValue = "0",required = false) int targetIuser){
        final int ROW_COUNT = 30;
        FeedSelDto dto = FeedSelDto.builder()
                .loginedIuser(loginedIuser)
                .rowCount(ROW_COUNT)
                .startIdx((page-1) * ROW_COUNT)
                .targetIuser(targetIuser)
                .build();
        return service.getFeedAll(dto);
    }
}
