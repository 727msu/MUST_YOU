package edu.collage.campus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.collage.campus.entity.OrderDetailJSONObj;
import edu.collage.campus.entity.OrderDetailsView;
import edu.collage.campus.mapper.orderMapper;
import edu.collage.campus.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<orderMapper, OrderDetailsView> implements OrderService {
    final orderMapper orderMapper;

    public OrderServiceImpl(orderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public List<OrderDetailJSONObj> getUserOrderDetailForJSON(LocalDate date, String username, String phone) {
        return orderMapper.getUserOrderDetailForJSON(date, username, phone);
    }

    @Override
    public List<OrderDetailsView> getUserOrder(LocalDate date, String username, String phone) {
        return orderMapper.getUserOrder(date, username, phone);
    }
}
