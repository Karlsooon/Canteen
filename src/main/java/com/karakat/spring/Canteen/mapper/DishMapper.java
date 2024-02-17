package com.karakat.spring.Canteen.mapper;
import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.model.Dish;
import org.mapstruct.Mapper;

import java.util.stream.BaseStream;

@Mapper(componentModel = "spring")
public interface DishMapper extends BaseMapper<Dish, DishDto> {

}
