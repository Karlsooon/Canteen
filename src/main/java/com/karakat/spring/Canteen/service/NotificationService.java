package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.dto.UserDto;

import java.util.List;

public interface NotificationService {

    List<NotificationDto> findAllNotifications();
    NotificationDto createNotification(NotificationDto notificationDto);
    void deleteNotification(Long id);



}
