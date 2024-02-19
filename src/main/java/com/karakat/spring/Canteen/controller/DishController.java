package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dish")
public class DishController {

    private final DishService dishService;

    @GetMapping("/all")
//    @PreAuthorize("hasRole('client_admin')")
    public List<DishDto> findAll(){
        return dishService.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('client_admin')")
    public DishDto findById(@PathVariable Long id){
       return dishService.findById(id);

    }

    @PostMapping(value = "/create", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    //    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<DishDto> createDish(@ModelAttribute DishDto dishDto, @RequestParam("image") MultipartFile imageFile) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(dishService.save(dishDto, imageFile));
    }

}
