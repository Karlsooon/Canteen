package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userServiceImpl.findAll());
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
    public void addNotificationToUser(@PathVariable Long id,@RequestParam List<Long> notificationDtoIds) {
        userServiceImpl.addNotificationToUser(id, notificationDtoIds);
    }
}
