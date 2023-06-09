package com.zsj.word.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class QiNiuConfig {

    //七牛云 ak
    @Value("${qiniu.accessKey}")
    private String accessKey;

    //七牛云sk
    @Value("${qiniu.accessSecretKey}")
    private String secretKey;

    //指定七牛云空间
    @Value("${qiniu.bucket}")
    private String bucket;

    //文件名路径前缀
    @Value("${qiniu.prefix:}")
    private String prefix;

    //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
    @Value("${qiniu.delimiter:}")
    private String delimiter;

    //七牛云空间的域名
    @Value("${qiniu.domain}")
    private String domain;

}
