package com.karakat.spring.Canteen.service.impl;

import com.karakat.spring.Canteen.dto.NotificationDto;
import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.UserMapper;
import com.karakat.spring.Canteen.model.Orders;
import com.karakat.spring.Canteen.model.User;
import com.karakat.spring.Canteen.repository.OrderRepository;
import com.karakat.spring.Canteen.repository.UserRepository;
import com.karakat.spring.Canteen.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrderRepository orderRepository;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    @Override
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
    public void addNotificationToUser(NotificationDto notificationDto) {

    }
}
