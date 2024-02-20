package com.karakat.spring.Canteen.service;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.exception.ResourceNotFoundException;
import com.karakat.spring.Canteen.mapper.DishMapper;
import com.karakat.spring.Canteen.model.Dish;
import com.karakat.spring.Canteen.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface DishService {
    public List<DishDto> findAll();
    public DishDto findById(Long id);
    public DishDto save(DishDto dishDto, MultipartFile imageFile);
    public DishDto updateDish(DishDto dishDto);

    public ResponseEntity<String> deleteDish(DishDto dishDto, Long id);



}
