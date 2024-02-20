package com.karakat.spring.Canteen.service.impl;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.NotificationMapper;
import com.karakat.spring.Canteen.model.Notification;
import com.karakat.spring.Canteen.repository.NotificationRepository;
import com.karakat.spring.Canteen.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        Notification notification = notificationMapper.toEntity(notificationDto);
        Notification saveNotification = notificationRepository.save(notification);
        notificationDto.setId(saveNotification.getId());
        return notificationDto;
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);

    }

    @Override
    public NotificationDto addUserToNotification(Long id, UserDto userDto) {
        Notification notification = notificationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("notification id not found"));

        return null;
    }
}
