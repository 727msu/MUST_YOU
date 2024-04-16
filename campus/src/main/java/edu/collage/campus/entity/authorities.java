package edu.collage.campus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName authorities
 */
@TableName(value ="authorities")
@Data
public class authorities implements Serializable {
    /**
     * 
     */
    @TableField(value = "username")
    private String username;

    /**
     * 
     */
    @TableField(value = "authority")
    private String authority;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 121611780836603287L;
}