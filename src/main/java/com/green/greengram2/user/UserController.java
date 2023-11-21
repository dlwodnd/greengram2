package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.models.UserSigninDto;
import com.green.greengram2.user.models.UserSigninVo;
import com.green.greengram2.user.models.UserSignupDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//Spring Framework Log For j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@Tag(name = "유저 API", description = "인증관련")
public class UserController {
    private final UserService service;


    @PostMapping("/signin")
    @Operation(summary = "인증", description = "아이디/비번을 이용한 인증처리")
    @Parameters(value = {
            @Parameter(name = "uid", description = "아이디")
            , @Parameter(name = "upw", description = "비밀번호")
    })
    public UserSigninVo userSignin(@RequestBody UserSigninDto dto) {
        return service.userSignin(dto);
    }

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원가입 처리")
    @Parameters(value = {
            @Parameter(name = "uid", description = "아이디")
            , @Parameter(name = "upw", description = "비밀번호")
            , @Parameter(name = "nm", description = "이름")
            , @Parameter(name = "pic", description = "프로필 사진")
    })
    public ResVo userSignUp(@RequestBody UserSignupDto dto) {
        return service.userSignup(dto);//ResVo객체에 insert한 레코드 pk값을 담아서 응답처리
    }
}
