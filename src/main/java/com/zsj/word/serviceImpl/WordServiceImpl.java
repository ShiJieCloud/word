package com.zsj.word.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsj.word.constant.SystemConstants;
import com.zsj.word.mapper.WordMapper;
import com.zsj.word.pojo.Tag;
import com.zsj.word.pojo.Word;
import com.zsj.word.service.TagService;
import com.zsj.word.service.WordService;
import com.zsj.word.service.WordTagService;
import com.zsj.word.utils.RedisUtils;
import com.zsj.word.vo.WordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jie
 * @since 2023-06-09 03:44:26
 */
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements WordService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private TagService tagService;

    @Autowired
    private WordTagService wordTagService;

    @Override
    public void syncRedisWords() {
        List<Word> words = list();
        redisUtils.setCacheSet(SystemConstants.REDIS_KEY_WORD,words);
        System.out.println("word 同步 Redis 完成");
    }

    @Override
    public WordVO randomWord() {
        Word word = redisUtils.getRandomSet(SystemConstants.REDIS_KEY_WORD);
        if(Objects.isNull(word)) {
            syncRedisWords();
            word = randomWord().getWord();
        }
        //获取 tag
        List<Integer> wordTagIds = wordTagService.getWordTags(word.getId());
        List<Tag> tags = tagService.getTags(wordTagIds);

        return new WordVO(word,tags);
    }

}
