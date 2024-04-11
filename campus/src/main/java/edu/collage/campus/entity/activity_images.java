package edu.collage.campus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName activity_images
 */
@TableName(value ="activity_images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class activity_images implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "activity_id")
    private Long activityId;

    /**
     * 
     */
    @TableField(value = "image_url")
    private String imageUrl;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 5521013343530426922L;
}