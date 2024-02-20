package com.karakat.spring.Canteen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoRequest {
    private Long id;
    private List<Long> dishIds; // Instead of List<Dish>, use List<Long> to represent Dish IDs
}
