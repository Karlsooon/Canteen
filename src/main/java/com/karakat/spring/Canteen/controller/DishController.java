package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.service.DishService;
import com.karakat.spring.Canteen.service.impl.DishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dish")
public class DishController {

    private final DishService dishService;
    @GetMapping("/all")
    public List<DishDto> findAll(){
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public DishDto findById(@PathVariable Long id){
       return dishService.findById(id);

    }

//    @PreAuthorize("hasRole('admin')")
    @PostMapping(value = "/create", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<DishDto> createDish(@ModelAttribute DishDto dishDto, @RequestParam("image") MultipartFile imageFile)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(dishService.save(dishDto, imageFile));
    }
    @PostMapping(value = "/update")
//    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<DishDto> updateDish(@ModelAttribute DishDto dishDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dishService.updateDish(dishDto));
    }

    @PostMapping("/delete/{id}")
//    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<String> deleteDish(@ModelAttribute DishDto dishDto, @PathVariable Long id){
        return dishService.deleteDish(dishDto,id);
    }


}
