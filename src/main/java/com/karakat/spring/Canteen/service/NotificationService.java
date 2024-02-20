package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.dto.UserDto;

public interface NotificationService {
    NotificationDto createNotification(NotificationDto notificationDto);
    void deleteNotification(Long id);


}
