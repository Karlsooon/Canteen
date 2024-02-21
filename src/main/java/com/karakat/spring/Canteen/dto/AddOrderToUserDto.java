package com.karakat.spring.Canteen.dto;

import com.karakat.spring.Canteen.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderToUserDto {
    private List<Orders> orderIds;
}
