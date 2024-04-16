package edu.collage.campus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.collage.campus.entity.OrderDetailJSONObj;
import edu.collage.campus.entity.OrderDetailsView;
import edu.collage.campus.mapper.orderMapper;

import java.time.LocalDate;
import java.util.List;


public interface OrderService extends IService<OrderDetailsView> {
    List<OrderDetailJSONObj> getUserOrderDetailForJSON(LocalDate date, String username, String phone);

    List<OrderDetailsView> getUserOrder(LocalDate date, String username, String phone);
}
