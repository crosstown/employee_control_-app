package com.crosstown.employee_control.services;

import com.crosstown.employee_control.domain.BU;
import com.crosstown.employee_control.repositories.BURepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author F.S.(Crosstown)
 * @date 11/24/2017
 * @time 1:36 AM
 */

@Slf4j
@Service
public class BUServiceImpl implements BUService {

    BURepository buRepository;

    public BUServiceImpl(BURepository buRepository) {
        this.buRepository = buRepository;
    }

    @Override
    public List<BU> allBU() {
        List<BU> all =  new ArrayList<>();
        buRepository.findAll().iterator().forEachRemaining(all::add);

        return all;
    }
}
