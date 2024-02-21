package com.karakat.spring.Canteen.service;

//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> allOrders();
    OrderDto getOrderById(Long id);
    OrderDto createOrder(OrderDto orderDto, List<Long> dishIds);
    void deleteOrder(Long id);
    OrderDto addDish(Long id,List<Long> dishDto);
}
