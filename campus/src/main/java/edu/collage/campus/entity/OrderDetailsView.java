package edu.collage.campus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.JsonNode;
import edu.collage.campus.config.JsonNodeTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @TableName order_details_view view
 */
@TableName(value = "order_details_view")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsView implements Serializable {


    @TableField(value = "id")
    private Long id;


    @TableField(value = "timeSlot")
    private Integer timeslot;


    @TableField(value = "date")
    private LocalDate date;


    @TableField(value = "qrcode")
    private String qrcode;


    @TableField(value = "avatar",typeHandler = JsonNodeTypeHandler.class)
    private JsonNode avatar;


    @TableField(value = "activity",typeHandler = JsonNodeTypeHandler.class)
    private JsonNode activity;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 3311867088255977834L;
}