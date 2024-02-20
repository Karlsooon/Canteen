package com.karakat.spring.Canteen.mapper;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.model.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface NotificationMapper extends BaseMapper<Notification, NotificationDto> {
}
