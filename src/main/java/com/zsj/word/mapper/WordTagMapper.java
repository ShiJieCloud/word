package com.zsj.word.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsj.word.pojo.WordTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jie
 * @since 2023-06-09 03:44:26
 */
@Mapper
public interface WordTagMapper extends BaseMapper<WordTag> {

    /**
     * 获取word相关的tag
     * @param wordId
     * @return
     */
    List<Integer> getWordKTags(Integer wordId);

}
