package edu.collage.campus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailJSONObj {


    @TableField(value = "id")
    private Long id;


    @TableField(value = "start_time")
    private LocalTime startTime;


    @TableField(value = "end_time")
    private LocalTime endTime;


    @TableField(value = "qr_code")
    private String qrCode;


    @TableField(value = "timeSlot")
    private int timeSlot;


    @TableField(value = "organization")
    private String organization;


    @TableField(value = "user")
    private JsonNode user;


    @TableField(value = "activities")
    private JsonNode activities;
}
