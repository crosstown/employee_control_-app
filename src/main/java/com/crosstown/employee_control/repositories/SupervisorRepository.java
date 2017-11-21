package com.crosstown.employee_control.repositories;

import com.crosstown.employee_control.domain.Supervisor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 4:07 PM
 */
public interface SupervisorRepository extends CrudRepository<SupervisorRepository, Long>{


    Optional<Supervisor> findByLastName(String lastName);
}
