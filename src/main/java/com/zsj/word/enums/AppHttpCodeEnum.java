package com.zsj.word.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppHttpCodeEnum {

    SUCCESS(200,"操作成功"),
    BAD_REQUEST(400,"请求参数错误"),
    NEED_LOGIN(400,"需要登录后操作"),
    NO_OPERATOR_AUTH(400,"您没有该权限，请联系管理员"),
    SYSTEM_ERROR(500,"发生错误，请重试"),;

    int code;
    String msg;

}

