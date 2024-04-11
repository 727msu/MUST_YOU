package edu.collage.campus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.BindParam;

/**
 * 
 * @TableName activity
 */
@TableName(value ="activity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class activity implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "desc_")
    private String desc;

    /**
     * 
     */
    @TableField(value = "price")
    private Double price;

    /**
     * 
     */
    @TableField(value = "title")
    private String title;

    @TableField(exist = false)
    private List<String> images;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -5002734857743608463L;
}