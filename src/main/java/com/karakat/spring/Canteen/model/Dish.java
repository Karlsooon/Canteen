package com.karakat.spring.Canteen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dish {
    @Id
    private Long id;
    private String name;
    private Double price;
    private String description;
    @Lob
    private String image; // New field for storing image content
    private String category;
    @ManyToMany(mappedBy = "dishList")
    private List<Orders> ordersList;
    @ManyToMany(mappedBy = "dishList")
    private List<OrderHistory> orderHistoryList;
}
