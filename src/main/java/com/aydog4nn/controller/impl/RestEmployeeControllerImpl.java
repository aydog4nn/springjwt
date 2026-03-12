package com.aydog4nn.controller.impl;

import com.aydog4nn.controller.IRestEmployeeController;
import com.aydog4nn.dto.DtoEmployee;
import com.aydog4nn.service.IEmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class RestEmployeeControllerImpl implements IRestEmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    @GetMapping("/{id}")
    @Override
    public DtoEmployee findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }
}
