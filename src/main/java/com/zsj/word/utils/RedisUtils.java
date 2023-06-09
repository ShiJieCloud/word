package com.zsj.word.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 缓存Set
     *
     * @param key     缓存键值
     * @param data 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final List<T> data) {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        data.forEach(f -> setOperation.add(f));
        return setOperation;
    }

    /**
     * 获取set的随机一个元素
     *
     * @param key
     * @return
     */
    public <T> T getRandomSet(final String key) {
        SetOperations<String,T> operation = redisTemplate.opsForSet();
        return operation.randomMember(key);
    }


    /**
     * 获取set的大小
     *
     * @param key
     * @return
     */
    public Long getSetSize(final String key) {
        return redisTemplate.opsForSet().size(key);
    }


    /**
     * 往Hash中存入数据
     *
     * @param key   Redis键
     * @param hKey  Hash键
     * @param value 值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey) {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }


}
