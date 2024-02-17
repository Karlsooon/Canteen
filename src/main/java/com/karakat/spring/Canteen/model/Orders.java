package com.karakat.spring.Canteen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @ManyToMany
    @JoinTable(name = "order_dish", joinColumns=@JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishList;
    private String status;
    private Timestamp localDateTime;
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;
}
