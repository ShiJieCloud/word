package com.zsj.word.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zsj.word.enums.AppHttpCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T>  {

    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result okResult(){
        return new Result(AppHttpCodeEnum.SUCCESS.getCode(), AppHttpCodeEnum.SUCCESS.getMsg());
    }

    public static Result okResult(Object data){
        return new Result(AppHttpCodeEnum.SUCCESS.getCode(), AppHttpCodeEnum.SUCCESS.getMsg(),data);
    }

    public static Result errorResult(){
        return new Result(AppHttpCodeEnum.BAD_REQUEST.getCode(), AppHttpCodeEnum.BAD_REQUEST.getMsg());
    }

}
