package com.crosstown.employee_control.repositories;

import com.crosstown.employee_control.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author developer
 * @date 2019-05-16
 * @time 19:39
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
