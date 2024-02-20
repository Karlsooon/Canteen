package com.karakat.spring.Canteen.dto;

import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.model.Payment;
import com.karakat.spring.Canteen.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderDto {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @ManyToMany
    @JoinTable(name = "order_dish", joinColumns=@JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishList;
//    private String status;
//    private Timestamp localDateTime;
//    @OneToOne
//    @JoinColumn(name = "payment_id", referencedColumnName = "id")
//    private Payment payment;
}
