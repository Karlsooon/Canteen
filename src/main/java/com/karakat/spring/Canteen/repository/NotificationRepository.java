package com.karakat.spring.Canteen.repository;

import com.karakat.spring.Canteen.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
