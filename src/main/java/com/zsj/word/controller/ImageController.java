package com.zsj.word.controller;

import com.zsj.word.pojo.Result;
import com.zsj.word.utils.QINiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/image")
@RestController
public class ImageController {

    @Autowired
    private QINiuUtils qiNiuUtils;

    @RequestMapping("/random")
    public Result randomImg(){
        return Result.okResult(qiNiuUtils.randomImgUrl());
    }

}
