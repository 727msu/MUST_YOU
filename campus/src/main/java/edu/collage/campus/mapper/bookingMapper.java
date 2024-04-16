package edu.collage.campus.mapper;

import edu.collage.campus.entity.UsersCount;
import edu.collage.campus.entity.booking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;


@Mapper
public interface bookingMapper extends BaseMapper<booking> {
    List<UsersCount> getGroupForNumber(LocalDate date);
}




