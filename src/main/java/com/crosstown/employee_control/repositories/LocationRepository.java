package com.crosstown.employee_control.repositories;

import com.crosstown.employee_control.domain.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 4:04 PM
 */
public interface LocationRepository extends CrudRepository<Location, Long> {


    Optional<Location> findByDescription (String description);
}
