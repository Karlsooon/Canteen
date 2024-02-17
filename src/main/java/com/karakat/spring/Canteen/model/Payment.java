package com.karakat.spring.Canteen.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    private Long id;
    @OneToOne(mappedBy = "payment")
    private Orders orders;
    private Double amount;
    private String status;
    private Timestamp localDateTime;
}
