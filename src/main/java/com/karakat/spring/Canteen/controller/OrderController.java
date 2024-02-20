package com.karakat.spring.Canteen.controller;

//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.OrderDtoRequest;
import com.karakat.spring.Canteen.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/order")
@Slf4j
@Transactional
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    @Transactional(readOnly = true)
    @GetMapping("/all")
    public List<OrderDto> allOrders() {
        return orderServiceImpl.allOrders();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderServiceImpl.getOrderById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDtoRequest orderDtoRequest) {
        OrderDto createdOrderDto = orderServiceImpl.createOrder(orderDtoRequest);
        return ResponseEntity.ok(createdOrderDto);
    }


    @DeleteMapping("/{id}/delete")
    public void deleteOrder(@PathVariable Long id) {
        orderServiceImpl.deleteOrder(id);

    }

    @PostMapping("/{id}/addDish")
    public OrderDto addDish(@PathVariable Long id,@RequestParam List<Long> dishDtoIds) {
        return orderServiceImpl.addDish(id,dishDtoIds);
    }


}
