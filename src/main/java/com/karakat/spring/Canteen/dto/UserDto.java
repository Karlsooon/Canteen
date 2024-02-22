package com.karakat.spring.Canteen.dto;
import com.karakat.spring.Canteen.model.Notification;
import com.karakat.spring.Canteen.model.OrderHistory;
import com.karakat.spring.Canteen.model.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<OrderDto> orderIds;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Orders> orderIds;
//    @OneToMany(mappedBy = "recipient",cascade = CascadeType.ALL)
//    private List<Notification> notificationList;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<OrderHistory> orderHistoryList;
}
