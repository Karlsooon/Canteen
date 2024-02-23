package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.dto.UserRequest;
import com.karakat.spring.Canteen.mapper.UserMapper;
import com.karakat.spring.Canteen.model.AppUser;
import com.karakat.spring.Canteen.model.Orders;
import com.karakat.spring.Canteen.service.UserService;
import com.karakat.spring.Canteen.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    //fix some empty lists
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        log.info("Entering getAllUsers method");

        var users = userService.allUsers();
        log.info("Exiting getAllUsers method with result: {}", users);


        return ResponseEntity.ok(users);
    }



    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest userRequest){
        UserRequest userRequestCreate = userService.createUser(userRequest);
        return ResponseEntity.ok(userRequestCreate);
    }

    @DeleteMapping ("/{id}/delete")
    public void deleteUser(@PathVariable Long id){
         userService.deleteUser(id);
    }

    @PostMapping("/{id}/addOrder")
    public ResponseEntity<?> addOrderToUser(@PathVariable Long id, @RequestParam List<Long> orderIds){
        if(orderIds.isEmpty()){
            throw  new IllegalArgumentException("List of order Id's empty ");
        }
         userService.addOrderToUser(id, orderIds);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/addNotification")
    public void addNotificationToUser(@PathVariable Long id, @RequestParam List<Long> notificationIds) {
        if(notificationIds.isEmpty()){
            throw new IllegalArgumentException("List of notification Id's empty ");
        }
        userService.addNotificationToUser(id, notificationIds);
    }

}
