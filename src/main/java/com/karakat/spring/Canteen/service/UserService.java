package com.karakat.spring.Canteen.service;

//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.dto.UserRequest;
import com.karakat.spring.Canteen.model.AppUser;

        import java.util.List;

public interface UserService {
    List<UserDto> allUsers();
    UserDto getUserById(Long id);

    UserRequest createUser(UserRequest userDto);

    void deleteUser(Long id);


    void addOrderToUser(Long id,List<Long> orderIds);

    void addNotificationToUser(Long id, List<Long> notificationIds);

    //order history automatically when dishList ordered

}
