package com.karakat.spring.Canteen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dish {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String image;
    private String category;
}
