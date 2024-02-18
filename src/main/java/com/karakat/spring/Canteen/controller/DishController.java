package com.karakat.spring.Canteen.controller;

import com.karakat.spring.Canteen.dto.DishDto;
import com.karakat.spring.Canteen.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
//    @PreAuthorize("hasRole('client_admin')")
    public void createDish(@RequestBody DishDto dishDto){
        dishService.save(dishDto);


    }

}
