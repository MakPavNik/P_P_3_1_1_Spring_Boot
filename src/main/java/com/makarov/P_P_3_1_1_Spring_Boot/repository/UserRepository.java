package com.makarov.P_P_3_1_1_Spring_Boot.repository;

import com.makarov.P_P_3_1_1_Spring_Boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
