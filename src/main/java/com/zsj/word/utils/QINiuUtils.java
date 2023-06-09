package com.zsj.word.utils;

import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.zsj.word.config.QiNiuConfig;
import com.zsj.word.constant.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class QINiuUtils {

    @Autowired
    private QiNiuConfig qiNiuConfig;

    @Autowired
    private RedisUtils redisUtils;

    public String randomImgUrl(){
        String url = redisUtils.getRandomSet(SystemConstants.REDIS_KEY_IMGURLS);
        if(Objects.isNull(url)) {
            syncRedisImgUrls();
            url = randomImgUrl();
        }
        return url;
    }

    // 同步 Redis
    public void syncRedisImgUrls(){
        redisUtils.setCacheSet(SystemConstants.REDIS_KEY_IMGURLS,imgUrls());
        System.out.println("Img 外链同步 Redis 完成");
    }

    public List<String> imgUrls(){
        //...其他参数参考类注释
        String accessKey = qiNiuConfig.getAccessKey();
        String secretKey = qiNiuConfig.getSecretKey();
        String bucket = qiNiuConfig.getBucket();
        String prefix = qiNiuConfig.getPrefix();
        String delimiter = qiNiuConfig.getDelimiter();
        String domain = qiNiuConfig.getDomain();

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());

        Auth auth = Auth.create(accessKey, secretKey);

        BucketManager bucketManager = new BucketManager(auth, cfg);

        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;

        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            //stream流过滤掉掉多余的元素，并将其余元素的所有文件路径和域名进行拼接，返回所有图片外链的集合
            List<String> collect = Arrays.stream(items).filter(f -> !f.key.equals(prefix)).map(f -> domain+f.key).collect(Collectors.toList());
            return collect;
        }
        return null;
    }
}
