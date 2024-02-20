package com.karakat.spring.Canteen.service.impl;

import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.OrderMapper;
import com.karakat.spring.Canteen.model.Orders;
import com.karakat.spring.Canteen.repository.OrderRepository;
import com.karakat.spring.Canteen.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public List<OrderDto> allOrders() {
        List<Orders> orders = orderRepository.findAll();
        return orderMapper.toDto(orders);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Orders order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order does not exist"));
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Orders order = orderMapper.toEntity(orderDto);
        Orders saveOrder = orderRepository.save(order);
        orderDto.setId(saveOrder.getId());
        return orderDto;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);

    }
}
