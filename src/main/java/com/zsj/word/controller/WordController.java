package com.zsj.word.controller;


import com.zsj.word.constant.SystemConstants;
import com.zsj.word.pojo.Result;
import com.zsj.word.service.WordService;
import com.zsj.word.utils.QINiuUtils;
import com.zsj.word.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jie
 * @since 2023-06-09 03:44:26
 */
@RestController
@RequestMapping("/api/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping("/random")
    public Result randomImg(){
        return Result.okResult(wordService.randomWord());
    }

}
