package com.example.demojparelationship.repository.OneToOne;

import com.example.demojparelationship.entity.OneToOne.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
