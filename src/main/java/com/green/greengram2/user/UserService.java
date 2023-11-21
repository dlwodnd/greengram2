package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserMapper mapper;

    public UserSigninVo userSignin(UserSigninDto dto) {
        UserSigninProcVo pVo = mapper.selByUpw(dto);
        UserSigninVo vo = new UserSigninVo();
        vo.setResult(3);
        if(pVo == null){
            vo.setResult(2);
            return vo;
        }
        else if(BCrypt.checkpw(dto.getUpw(),pVo.getUpw())){
            vo.setNm(pVo.getNm());
            vo.setPic(pVo.getPic());
            vo.setIuser(pVo.getIuser());
            vo.setResult(1);
        }


        return vo;
    }

    public ResVo userSignup(UserSignupDto dto){
        String hashedPw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());

        UserSignupProcDto pDto = UserSignupProcDto.builder()
                .uid(dto.getUid())
                .upw(hashedPw)
                .pic(dto.getPic())
                .nm(dto.getNm())
                .build();
        int result = mapper.userSignup(pDto);

        if(result == 0){
            return new ResVo(0);
        }

        return new ResVo(pDto.getIuser());
    }
}
