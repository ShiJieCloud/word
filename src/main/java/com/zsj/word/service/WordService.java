package com.zsj.word.service;

import com.zsj.word.pojo.Word;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zsj.word.vo.WordVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jie
 * @since 2023-06-09 03:44:26
 */
public interface WordService extends IService<Word> {

    /**
     * 同步 Redis
     */
    void syncRedisWords();

    /**
     * 获取随机 Word
     * @return
     */
    WordVO randomWord();
}
