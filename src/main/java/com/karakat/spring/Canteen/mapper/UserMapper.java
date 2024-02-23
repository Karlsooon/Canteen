package com.karakat.spring.Canteen.mapper;

import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.model.AppUser;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.model.Notification;
import com.karakat.spring.Canteen.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface UserMapper extends BaseMapper<AppUser, UserDto>{

    @Override
    @Mapping(source = "ordersList", target = "orderIds")
    @Mapping(source = "notificationList", target = "notificationIds")
    UserDto toDto(AppUser entity);


    default List<Long> ordersListToOrderIds(List<Orders> ordersList){
        return ordersList.stream().map(Orders::getId).collect(Collectors.toList());
    }

    default List<Long> mapNotificationListToIds(List<Notification> NotificationList) {
        return NotificationList.stream()
                .map(Notification::getId)
                .collect(Collectors.toList());
    }

}

