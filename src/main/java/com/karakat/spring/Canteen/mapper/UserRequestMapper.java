package com.karakat.spring.Canteen.mapper;

import com.karakat.spring.Canteen.dto.UserDto;
import com.karakat.spring.Canteen.dto.UserRequest;
import com.karakat.spring.Canteen.model.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface UserRequestMapper extends BaseMapper<AppUser, UserRequest>{
}
