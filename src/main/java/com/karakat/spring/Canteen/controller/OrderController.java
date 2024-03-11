package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@Slf4j
@Transactional
public class OrderController {
    private final OrderServiceImpl orderService;

    @Transactional(readOnly = true)
    @GetMapping("/all")
    public List<OrderDto> allOrders() {
        return orderService.allOrders();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto, @RequestParam List<Long> dishIds) {
        OrderDto createdOrderDto = orderService.createOrder(orderDto, dishIds);
        return ResponseEntity.ok(createdOrderDto);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);

    }




}
