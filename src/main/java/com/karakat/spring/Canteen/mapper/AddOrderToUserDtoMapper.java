package com.karakat.spring.Canteen.mapper;

import com.karakat.spring.Canteen.dto.AddOrderToUserDto;
import com.karakat.spring.Canteen.model.AppUser;
import com.karakat.spring.Canteen.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AddOrderToUserDtoMapper extends BaseMapper<AppUser, AddOrderToUserDto>{

    @Override
    @Mapping(source = "ordersList", target = "orderIds")
    AddOrderToUserDto toDto(AppUser appUser);

    default List<Long> ordersListToOrderIds(List<Orders> ordersList){
        return ordersList.stream().map(Orders :: getId).collect(Collectors.toList());
    }
}
