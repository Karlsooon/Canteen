package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.DishDto;
//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.OrderDtoRequest;

import java.util.List;

public interface OrderService {
    List<OrderDto> allOrders();
    OrderDto getOrderById(Long id);
    OrderDto createOrder(OrderDtoRequest orderDtoRequest);
    void deleteOrder(Long id);
    OrderDto addDish(Long id,List<Long> dishDto);
}
