package com.karakat.spring.Canteen.model;
import jakarta.persistence.Entity;
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
    private Long id;
    private User user;
    private List<Dish> dishList;
    private Timestamp localDateTime;
}
