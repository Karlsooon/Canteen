package com.karakat.spring.Canteen.mapper;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.model.Notification;
import com.karakat.spring.Canteen.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface NotificationMapper extends BaseMapper<Notification, NotificationDto> {



}
