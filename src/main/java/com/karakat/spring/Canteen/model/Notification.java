package com.karakat.spring.Canteen.model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Notification", schema = "schema_canteen")
public class Notification {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NonNull
    private AppUser recipient;
    @Column(name = "message")
    @Lob
    @NonNull
    private String message;
    @Column(name = "sendedTime")
    private Timestamp localDateTime;
}
