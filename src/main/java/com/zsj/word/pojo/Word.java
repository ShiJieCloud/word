package com.zsj.word.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jie
 * @since 2023-06-09 03:44:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("word")
public class Word {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("content")
    private String content;

    @TableField("excerpt")
    private String excerpt;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

}
