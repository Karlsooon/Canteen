package com.karakat.spring.Canteen.mapper;

import com.karakat.spring.Canteen.dto.OrderDto;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Orders, OrderDto> {

    @Override
    @Mapping(source = "dishList", target = "dishIds")
    OrderDto toDto(Orders entity);

    default List<Long> mapDishListToIds(List<Dish> dishList) {
        return dishList.stream()
                .map(Dish::getId)
                .collect(Collectors.toList());
    }
}




