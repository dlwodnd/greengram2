package com.green.greengram2.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserSignupProcDto {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}