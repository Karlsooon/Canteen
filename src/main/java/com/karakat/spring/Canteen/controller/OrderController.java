package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
