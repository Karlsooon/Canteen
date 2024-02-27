package com.karakat.spring.Canteen.model;

import enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dish", schema = "schema_canteen")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @Lob
    private String image;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "ordersList")
    @ManyToMany(mappedBy = "dishList")
    private List<Orders> ordersList;

}
