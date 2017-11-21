package com.crosstown.employee_control.repositories;

import com.crosstown.employee_control.domain.BU;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 4:10 PM
 */
public interface BURepository extends CrudRepository<BU, Long> {


    Optional<BU> findByDescription(String description);
}
