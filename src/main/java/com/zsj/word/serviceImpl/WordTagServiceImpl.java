package com.zsj.word.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsj.word.constant.SystemConstants;
import com.zsj.word.mapper.TagMapper;
import com.zsj.word.mapper.WordMapper;
import com.zsj.word.pojo.Tag;
import com.zsj.word.pojo.Word;
import com.zsj.word.pojo.WordTag;
import com.zsj.word.mapper.WordTagMapper;
import com.zsj.word.service.WordTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsj.word.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jie
 * @since 2023-06-09 03:44:26
 */
@Service
public class WordTagServiceImpl extends ServiceImpl<WordTagMapper, WordTag> implements WordTagService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private WordTagMapper wordTagMapper;

    @Autowired
    private WordMapper wordMapper;

    @Override
    public void syncRedisWordTags() {
        List<Word> words = wordMapper.selectList(new QueryWrapper<>());
        for (Word word : words) {
            List<Integer> wordKTagIds = wordTagMapper.getWordKTags(word.getId());
            wordKTagIds.forEach(t->redisUtils.setCacheMapValue(SystemConstants.REDIS_KEY_WORD_TAG,word.getId().toString(),wordKTagIds));
        }
        System.out.println("word_tag 同步 redis 完成");
    }

    @Override
    public List<Integer> getWordTags(Integer wordId) {
        List<Integer> ids = redisUtils.getCacheMapValue(SystemConstants.REDIS_KEY_WORD_TAG,wordId.toString());
        if(ids.size()==0){
            syncRedisWordTags();
            ids = getWordTags(wordId);
        }
        return ids;
    }

}
