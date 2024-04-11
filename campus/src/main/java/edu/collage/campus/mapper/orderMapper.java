package edu.collage.campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.collage.campus.entity.OrderDetailJSONObj;
import edu.collage.campus.entity.OrderDetailsView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface orderMapper extends BaseMapper<OrderDetailsView> {
    List<OrderDetailJSONObj> getUserOrderDetailForJSON(@Param("date") LocalDate date, @Param("username") String username, @Param("phone") String phone);

    List<OrderDetailsView> getUserOrder(@Param("date") LocalDate date, @Param("username") String username, @Param("phone") String phone);
}
