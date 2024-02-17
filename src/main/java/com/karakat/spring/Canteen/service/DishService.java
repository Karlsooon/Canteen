package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.DishMapper;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public List<DishDto> findAll(){
        List<Dish> dishList = dishRepository.findAll();
        if(dishList.isEmpty()){
            throw new ResourceNotFoundException("Products not found");
        }

        return dishMapper.toDto(dishList);

    }
}
