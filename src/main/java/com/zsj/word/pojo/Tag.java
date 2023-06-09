package com.zsj.word.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tag")
public class Tag {

    @TableField("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

}
