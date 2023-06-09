package com.zsj.word.service;

import com.zsj.word.pojo.Tag;
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
public interface TagService extends IService<Tag> {

    void syncRedisTags();

    List<Tag> getTags(List<Integer> tagIds);
}
