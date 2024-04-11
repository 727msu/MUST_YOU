package edu.collage.campus.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @TableName booking
 */
@TableName(value = "booking")
@Data
@AllArgsConstructor
public class booking implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    public booking(Long id, Long userId, LocalTime startTime, LocalTime endTime, LocalDate date, int timeSlot) {
        this.id = id;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    /**
     *
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     *
     */
    @TableField(value = "start_time")
    private LocalTime startTime;

    /**
     *
     */
    @TableField(value = "end_time")
    private LocalTime endTime;

    /**
     *
     */
    @TableField(value = "date")
    private LocalDate date;

    /**
     *
     */
    @TableField(value = "qr_code")
    private String qrCode;

    @TableField(value = "timeSlot")
    private int timeSlot;


    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -4760463582959272401L;
}