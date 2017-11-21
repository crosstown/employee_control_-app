package com.crosstown.employee_control.repositories;

import com.crosstown.employee_control.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 3:55 PM
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{


    Optional<Category> findByDescription(String description);
}
