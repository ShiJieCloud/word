package com.zsj.word.service;

import com.zsj.word.pojo.WordTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jie
 * @since 2023-06-09 03:44:26
 */
public interface WordTagService extends IService<WordTag> {

    void syncRedisWordTags();

    List<Integer> getWordTags(Integer wordId);
}
