package com.crosstown.employee_control.services;

import com.crosstown.employee_control.domain.Category;
import com.crosstown.employee_control.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author F.S.(Crosstown)
 * @date 11/25/2017
 * @time 1:18 AM
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> allCategory() {
        List<Category> all =  new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(all::add);

        return all;
    }
}
