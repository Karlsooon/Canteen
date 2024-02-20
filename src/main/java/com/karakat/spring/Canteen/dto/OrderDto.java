package com.karakat.spring.Canteen.dto;

import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.model.Payment;
import com.karakat.spring.Canteen.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private List<Long> dishIds;
}
