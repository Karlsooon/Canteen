package com.karakat.spring.Canteen.mapper;

//import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.dto.OrderDtoRequest;
import com.karakat.spring.Canteen.model.Orders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface OrderMapper extends BaseMapper<Orders, OrderDto>{
}
