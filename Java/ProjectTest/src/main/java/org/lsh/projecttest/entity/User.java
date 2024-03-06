package org.lsh.projecttest.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String sex;

    private String grade;

    private static final long serialVersionUID = 1L;
}