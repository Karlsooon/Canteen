package com.karakat.spring.Canteen.model;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {
    private Long id;
    private User recipient;
    private String message;
    private Boolean readStatus;
    private Timestamp localDateTime;
}
