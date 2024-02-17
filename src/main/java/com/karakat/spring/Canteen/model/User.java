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
public class User {
    private Long id;
    private String studentId;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String role;
}
