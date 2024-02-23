package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.mapper.UserMapper;
import com.karakat.spring.Canteen.model.AppUser;
import com.karakat.spring.Canteen.model.Orders;
import com.karakat.spring.Canteen.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private final UserMapper userMapper;
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<AppUser> users = userServiceImpl.findAll();
        List<UserDto> userDtos = users.stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }



    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(userServiceImpl.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userServiceImpl.createUser(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @DeleteMapping ("/{id}/delete")
    public void deleteUser(@PathVariable Long id){
         userServiceImpl.deleteUser(id);
    }

    @PostMapping("/{id}/addOrder")
    public void addOrderToUser(@PathVariable Long id, @RequestParam List<Long> orderDtoIds){
         userServiceImpl.addOrderToUser(id, orderDtoIds);
    }

    @PostMapping("/{id}/addNotification")
    public void addNotificationToUser(@PathVariable Long id, @RequestParam List<Long> notificationDtoIds) {
         userServiceImpl.addNotificationToUser(id, notificationDtoIds);
    }
}
