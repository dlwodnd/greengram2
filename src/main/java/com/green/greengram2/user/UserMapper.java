package com.green.greengram2.user;

import com.green.greengram2.user.models.UserSigninDto;
import com.green.greengram2.user.models.UserSigninProcVo;
import com.green.greengram2.user.models.UserSigninVo;
import com.green.greengram2.user.models.UserSignupProcDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userSignup(UserSignupProcDto pDto);
    UserSigninProcVo selByUpw (UserSigninDto dto);

}
