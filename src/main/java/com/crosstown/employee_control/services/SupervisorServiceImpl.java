package com.crosstown.employee_control.services;

import com.crosstown.employee_control.domain.Supervisor;
import com.crosstown.employee_control.repositories.SupervisorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author F.S.(Crosstown)
 * @date 11/23/2017
 * @time 11:11 PM
 */
@Slf4j
@Service
public class SupervisorServiceImpl implements SupervisorService {

    SupervisorRepository supervisorRepository;

    public SupervisorServiceImpl(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public List<Supervisor> allSupervisors() {

        List<Supervisor> all =  new ArrayList<>();
        supervisorRepository.findAll().iterator().forEachRemaining(all::add);

        return all;
    }
}
