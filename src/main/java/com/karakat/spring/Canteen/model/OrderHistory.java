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
public class OrderHistory {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "order_history_dish", joinColumns = @JoinColumn(name = "order_history_id"), inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishList;
    private Timestamp localDateTime;
}
