package com.zsj.word.serviceImpl;

import com.zsj.word.constant.SystemConstants;
import com.zsj.word.pojo.Tag;
import com.zsj.word.mapper.TagMapper;
import com.zsj.word.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsj.word.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void syncRedisTags() {
        List<Tag> tags = list();
        tags.forEach(t -> redisUtils.setCacheMapValue(SystemConstants.REDIS_KEY_TAG,t.getId().toString(),t));
        System.out.println("tag 同步 redis 完成");
    }

    @Override
    public List<Tag> getTags(List<Integer> tagIds) {
        List<Tag> tags = new ArrayList<>();
        for (Integer id : tagIds) {
            Tag tag = redisUtils.getCacheMapValue(SystemConstants.REDIS_KEY_TAG, id.toString());
            if(Objects.isNull(tag)){
                syncRedisTags();
                tag = redisUtils.getCacheMapValue(SystemConstants.REDIS_KEY_TAG, id.toString());
            }
            tags.add(tag);
        }
        return tags;
    }

}
