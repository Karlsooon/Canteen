package com.karakat.spring.Canteen.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<Long> orderIds;
    private List<Long> notificationIds;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<OrderHistory> orderHistoryList;
}
