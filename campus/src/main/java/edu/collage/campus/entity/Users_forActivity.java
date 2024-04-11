package edu.collage.campus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@TableName(value = "users__for_activity")
@Data
@AllArgsConstructor
public class Users_forActivity implements Serializable {
    public Users_forActivity(Long id, Long userId, Long activityId, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.activityId = activityId;
        this.date = date;
    }

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 外键 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 外键 活动id
     */
    @TableField(value = "activity_id")
    private Long activityId;

    /**
     * 日期
     */
    @TableField(value = "date")
    private LocalDate date;

    /**
     * qrcode
     */
    @TableField(value = "qrcode")
    private String qrcode;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -6500128307604997588L;
}