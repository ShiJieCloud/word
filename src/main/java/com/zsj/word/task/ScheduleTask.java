package com.zsj.word.task;

import com.zsj.word.service.TagService;
import com.zsj.word.service.WordService;
import com.zsj.word.service.WordTagService;
import com.zsj.word.utils.QINiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 定时任务
 */
@Component
public class ScheduleTask {

    @Autowired
    private WordService wordService;

    @Autowired
    private TagService tagService;

    @Autowired
    private WordTagService wordTagService;

    @Autowired
    private QINiuUtils qiNiuUtils;

    /**
     * 项目启动时初始化 Redis 中的图片外链
     */
    @PostConstruct
    public void initImgUrls(){
        qiNiuUtils.syncRedisImgUrls();
    }

    /**
     * 项目启动时初始化 Redis 中的 tag
     */
    @PostConstruct
    public void initTags(){
        tagService.syncRedisTags();
    }

    /**
     * 项目启动时初始化 Redis 中的 word_tag
     */
    @PostConstruct
    public void initWordTags(){
        wordTagService.syncRedisWordTags();
    }

    //项目启动时初始化 Redis 中的 word 数据
    @PostConstruct
    public void initWord() {
        //获取所有的word
        wordService.syncRedisWords();
    }

}