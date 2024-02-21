package com.karakat.spring.Canteen.service.impl;

//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.OrderMapper;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.model.Orders;
import com.karakat.spring.Canteen.repository.DishRepository;
import com.karakat.spring.Canteen.repository.OrderRepository;
import com.karakat.spring.Canteen.service.OrderService;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final DishRepository dishRepository;
    @Transactional(readOnly = true)
    public List<OrderDto> allOrders(){
        List<Orders> ordersList = orderRepository.findAll();
        if(ordersList.isEmpty()){
            throw new ResourceNotFoundException("Products not found");
        }

        return orderMapper.toDto(ordersList);

    }

    @Override
    @Transactional(readOnly = true)
    public OrderDto getOrderById(Long id) {
        Orders order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order does not exist"));
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto, List<Long> dishIds) {
        List<Dish> dishList = dishRepository.findAllById(dishIds);
        if(dishList.size()!=dishIds.size()){
            throw new IllegalArgumentException("dish id not found");
        }
        try {
            Orders order = orderMapper.toEntity(orderDto);
            order.setDishList(dishList);
            Orders savedOrder = orderRepository.save(order);
            return orderMapper.toDto(savedOrder);
        } catch (Exception e) {
            // Handle any exceptions (e.g., database errors) and log or return an appropriate response
            throw new RuntimeException("Failed to create order", e);
        }
    }



    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);

    }

    @Override
    public OrderDto addDish(Long id,List<Long> dishDtoIds) {
        Orders order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order doesnt exist"));
        List<Dish> dishs = dishRepository.findAllById(dishDtoIds);
        if(dishs.size()!=dishDtoIds.size()){
            throw new IllegalArgumentException("Could not find all specified tags");
        }
        if(order.getDishList().stream().anyMatch(dish -> dishs.contains(dish.getId()))){
            throw new IllegalArgumentException("Tag already added");
        }
        order.setDishList(dishs);
        orderRepository.save(order);

        return null;
    }
}
