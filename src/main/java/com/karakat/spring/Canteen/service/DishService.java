package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.DishMapper;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {
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
    @Transactional
    public DishDto save(DishDto dishDto, MultipartFile imageFile) throws IOException {
        // Store the image file and get its URL
        String imageUrl = storageService.store(imageFile);
        // Set the image URL in the DishDto
        dishDto.setImage(imageUrl);
        // Save the dish entity
        Dish savedDish = dishRepository.save(dishMapper.toEntity(dishDto));
        // Set the ID from the saved entity
        dishDto.setId(savedDish.getId());
        return dishDto;
    }


}
