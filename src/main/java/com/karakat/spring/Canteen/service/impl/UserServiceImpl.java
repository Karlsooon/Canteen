package com.karakat.spring.Canteen.service.impl;

//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.UserMapper;
import com.karakat.spring.Canteen.model.Notification;
import com.karakat.spring.Canteen.model.Orders;
import com.karakat.spring.Canteen.model.AppUser;
import com.karakat.spring.Canteen.repository.NotificationRepository;
import com.karakat.spring.Canteen.repository.OrderRepository;
import com.karakat.spring.Canteen.repository.UserRepository;
        import com.karakat.spring.Canteen.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
        List<AppUser> appUsers = userRepository.findAll();
        return userMapper.toDto(appUsers);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Long id) {
        AppUser appUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AppUser not found"));
        return userMapper.toDto(appUser);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        AppUser user = userMapper.toEntity(userDto);
        AppUser appUserSave = userRepository.save(user);
        userDto.setId(appUserSave.getId());
        return userDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }



    @Override
    public void addOrderToUser(Long id,List<Long> orderDtoIds) {
        AppUser appUser = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("AppUser not found"));
        List<Orders> tags = orderRepository.findAllById(orderDtoIds);
        if(tags.size()!=orderDtoIds.size()){
            throw  new IllegalArgumentException("Could not find all specified orders");
        }
        if(appUser.getOrdersList().stream().anyMatch(tag->orderDtoIds.contains(tag.getId()))){
            throw new IllegalArgumentException("Tag already added");
        }

        appUser.setOrdersList(tags);
        userRepository.save(appUser);


    }

    @Override
    public void addNotificationToUser(Long id,List<Long> notificationDtoIds) {
        AppUser user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AppUser with specific id not found"));
        List<Notification>  notificationDtos = notificationRepository.findAllById(notificationDtoIds);
        if(notificationDtos.size()!=notificationDtoIds.size()){
            throw new IllegalArgumentException("Could not find all specified tags");

        }
        if(user.getNotificationList().stream().anyMatch(notif -> {
            return notificationDtos.contains(notif.getId());
        })){
            throw new IllegalArgumentException("Tag already added");

        }

        user.setNotificationList(notificationDtos);
        userRepository.save(user);

    }
}
