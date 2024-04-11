package edu.collage.campus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupNumberSlot {
    private int timeSlot;
    private Integer numBooking;
    private boolean over;
}
