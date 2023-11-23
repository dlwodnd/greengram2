package com.green.greengram2.user;

import com.green.greengram2.user.models.*;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userSignup(UserSignupProcDto pDto);
    UserSigninProcVo selByUpw (UserSigninDto dto);
    UserInfoVo selUserInfo(int targetUser);

    int updUserPic(UserPatchPicDto dto);


}
