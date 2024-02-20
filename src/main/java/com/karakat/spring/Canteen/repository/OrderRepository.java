package com.karakat.spring.Canteen.repository;

import com.karakat.spring.Canteen.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
