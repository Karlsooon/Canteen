package com.karakat.spring.Canteen.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DishDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String image;
    private String category;
}
