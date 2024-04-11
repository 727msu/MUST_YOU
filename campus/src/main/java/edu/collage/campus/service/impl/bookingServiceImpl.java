package edu.collage.campus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.collage.campus.entity.UsersCount;
import edu.collage.campus.entity.booking;
import edu.collage.campus.service.bookingService;
import edu.collage.campus.mapper.bookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class bookingServiceImpl extends ServiceImpl<bookingMapper, booking>
        implements bookingService {
    final bookingMapper bookingMapper;
    // 定义一系列时间段的起始时间和结束时间

    private final LocalTime[] startTimes = new LocalTime[5];
    private final LocalTime[] endTimes = new LocalTime[5];


    public bookingServiceImpl(bookingMapper bookingMapper) {

        //10:00-11:30
        startTimes[0] = LocalTime.of(10, 0);
        endTimes[0] = LocalTime.of(11, 30);


        //11:30-13:00
        startTimes[1] = LocalTime.of(11, 30);
        endTimes[1] = LocalTime.of(13, 0);

        //13:00-14:30;
        startTimes[2] = LocalTime.of(13, 0);
        endTimes[2] = LocalTime.of(14, 30);

        //14:30-16:00
        startTimes[3] = LocalTime.of(14, 30);
        endTimes[3] = LocalTime.of(16, 0);

        //16:00-17:30
        startTimes[4] = LocalTime.of(16, 0);
        endTimes[4] = LocalTime.of(17, 30);
        this.bookingMapper = bookingMapper;
    }

    @Override
    public List<UsersCount> getGroupForNumber(LocalDate date) {
        return bookingMapper.getGroupForNumber(date);
    }

    @Override
    public LocalTime[] getCurrentTimeSlotNumber(int index) {
        return new LocalTime[]{startTimes[index], endTimes[index]};
    }


    /**
     * @param startTime
     * @param endTime
     * @return -1 不在定义的时间段内
     * @dec 检查给定时间是否在某个时间段内
     */
    @Override
    public int checkTimeSlot(LocalTime startTime, LocalTime endTime) {
        // 遍历时间段，检查给定时间是否在某个时间段内
        for (int i = 0; i < startTimes.length; i++) {
            LocalTime slotStartTime = startTimes[i];
            LocalTime slotEndTime = endTimes[i];
            if (startTime.isAfter(slotStartTime) && endTime.isBefore(slotEndTime)) {
                return i;
            } else if (startTime.equals(slotStartTime) && endTime.equals(slotEndTime)) {
                return i;
            }

        }
        return -1;
    }
}




