package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.service.impl.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
@Slf4j
@Transactional
public class NotificationController {
    private final NotificationServiceImpl notificationServiceImpl;

    @PostMapping("/create")
    public NotificationDto createNotification(@RequestParam NotificationDto notificationDto) {
        return notificationServiceImpl.createNotification(notificationDto);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteNotification(@PathVariable Long id) {
        notificationServiceImpl.deleteNotification(id);
    }

}
