package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.DishMapper;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    @Transactional(readOnly = true)

    public List<DishDto> findAll(){
        List<Dish> dishList = dishRepository.findAll();
        if(dishList.isEmpty()){
            throw new ResourceNotFoundException("Products not found");
        }

        return dishMapper.toDto(dishList);

    }
    @Transactional(readOnly = true)

    public DishDto findById(Long id){
        Dish dish=dishRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("product with this id "+id+"not found"));

        return dishMapper.toDto(dish);

    }
    @Transactional

    public DishDto save(DishDto dishDto){
        Dish save = dishRepository.save(dishMapper.toEntity(dishDto));
        dishDto.setId(save.getId());
        return dishDto;
    }


}
