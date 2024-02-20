package com.karakat.spring.Canteen.dto;

import com.karakat.spring.Canteen.model.User;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class NotificationDto {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User recipient;
    private String message;
    private Boolean readStatus;
}
