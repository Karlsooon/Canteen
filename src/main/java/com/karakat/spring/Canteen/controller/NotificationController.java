package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.service.impl.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notificationDto) {
        NotificationDto notificationDto1 = notificationServiceImpl.createNotification(notificationDto);
        return ResponseEntity.ok(notificationDto1);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteNotification(@PathVariable Long id) {
        notificationServiceImpl.deleteNotification(id);
    }

}
