package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.AddOrderToUserDto;
import com.karakat.spring.Canteen.dto.NotificationDto;
//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.model.AppUser;
import com.karakat.spring.Canteen.model.Notification;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

public interface UserService {
    List<AppUser> findAll();
    UserDto getUserById(Long id);

    UserDto createUser(UserDto userDto);

    void deleteUser(Long id);


    AddOrderToUserDto addOrderToUser(Long id,List<Long> orderDtoIds);

    void addNotificationToUser(Long id, List<Long> notificationDto);

    //order history automatically when dishList ordered

}
