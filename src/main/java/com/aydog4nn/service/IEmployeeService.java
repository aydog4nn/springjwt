package com.aydog4nn.service;

import com.aydog4nn.dto.DtoEmployee;

public interface IEmployeeService {

    DtoEmployee findEmployeeById(Long id);

}
