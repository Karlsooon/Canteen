package com.karakat.spring.Canteen.repository;

import com.karakat.spring.Canteen.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
