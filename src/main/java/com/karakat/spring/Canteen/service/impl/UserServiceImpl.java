package com.karakat.spring.Canteen.service.impl;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.UserMapper;
import com.karakat.spring.Canteen.model.Notification;
import com.karakat.spring.Canteen.model.Orders;
import com.karakat.spring.Canteen.model.User;
import com.karakat.spring.Canteen.repository.NotificationRepository;
import com.karakat.spring.Canteen.repository.OrderRepository;
import com.karakat.spring.Canteen.repository.UserRepository;
import com.karakat.spring.Canteen.service.NotificationService;
import com.karakat.spring.Canteen.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrderRepository orderRepository;
    private final NotificationRepository notificationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        var user = userMapper.toEntity(userDto);
        User userSave = userRepository.save(user);
        userDto.setId(userSave.getId());
        return userDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }



    @Override
    public void addOrderToUser(Long id,List<Long> orderDtoIds) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
        List<Orders> tags = orderRepository.findAllById(orderDtoIds);
        if(tags.size()!=orderDtoIds.size()){
            throw  new IllegalArgumentException("Could not find all specified orders");
        }
        if(user.getOrdersList().stream().anyMatch(tag->orderDtoIds.contains(tag.getId()))){
            throw new IllegalArgumentException("Tag already added");
        }

        user.setOrdersList(tags);
        userRepository.save(user);


    }

    @Override
    public void addNotificationToUser(Long id,List<Long> notificationDtoIds) {
        var user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with specific id not found"));
        List<Notification>  notificationDtos = notificationRepository.findAllById(notificationDtoIds);
        if(notificationDtos.size()!=notificationDtoIds.size()){
            throw new IllegalArgumentException("Could not find all specified tags");

        }
        if(user.getNotificationList().stream().anyMatch(notif -> notificationDtos.contains(notif.getId()))){
            throw new IllegalArgumentException("Tag already added");

        }

        user.setNotificationList(notificationDtos);
        userRepository.save(user);

    }
}
