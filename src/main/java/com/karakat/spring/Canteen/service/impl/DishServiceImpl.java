package com.karakat.spring.Canteen.service.impl;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.DishMapper;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.repository.DishRepository;
import com.karakat.spring.Canteen.service.DishService;
import com.karakat.spring.Canteen.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional

public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    private final StorageService storageService;

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
    public DishDto save(DishDto dishDto, MultipartFile imageFile) {
        String imageUrl = storageService.store(imageFile);
        var entity = dishMapper.toEntity(dishDto);
        entity.setImage(imageUrl);
        Dish savedDish = dishRepository.save(entity);
        dishDto.setId(savedDish.getId());

        return dishDto;
    }
    public DishDto updateDish(DishDto dishDto) {
        Long id = dishDto.getId();
        Dish dish=dishRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("dish with id: "+id+" doesnt exist"));
        dish.setName(dishDto.getName());
        dish.setCategory(dishDto.getCategory());
        dish.setPrice(dishDto.getPrice());
        dish.setCategory(dishDto.getCategory());

        Dish updated = dishRepository.save(dish);
        return dishMapper.toDto(updated);

    }

    public ResponseEntity<String> deleteDish(DishDto dishDto, Long id){
        Dish dish=dishRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("dish with id: "+id+" doesnt exist"));
        if(dish!=null){
            dishRepository.delete(dish);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
