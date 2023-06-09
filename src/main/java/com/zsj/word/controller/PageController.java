package com.zsj.word.controller;

import com.zsj.word.service.WordService;
import com.zsj.word.utils.QINiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    private WordService wordService;

    @Autowired
    private QINiuUtils qiNiuUtils;

    @RequestMapping("/")
    public String toIndex(Model model){
        model.addAttribute("word",wordService.randomWord());
        model.addAttribute("imgUrl",qiNiuUtils.randomImgUrl());
        return "index";
    }

}
