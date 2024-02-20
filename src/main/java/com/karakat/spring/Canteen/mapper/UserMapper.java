package com.karakat.spring.Canteen.mapper;

import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto>{
}
