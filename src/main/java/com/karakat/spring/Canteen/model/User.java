package com.karakat.spring.Canteen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;
    @OneToMany(mappedBy = "recipient",cascade = CascadeType.ALL)
    private List<Notification> notificationList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderHistory> orderHistoryList;
}
