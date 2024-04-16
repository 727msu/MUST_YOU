package edu.collage.campus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.collage.campus.entity.UsersCount;
import edu.collage.campus.entity.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface bookingService extends IService<booking> {

    List<UsersCount> getGroupForNumber(LocalDate date);

    LocalTime[] getCurrentTimeSlotNumber(int index);

    int checkTimeSlot(LocalTime startTime, LocalTime endTime);
}
