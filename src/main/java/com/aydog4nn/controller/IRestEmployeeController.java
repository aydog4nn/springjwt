package com.aydog4nn.controller;

import com.aydog4nn.dto.DtoEmployee;

public interface IRestEmployeeController {

    public DtoEmployee findEmployeeById(Long id);

}
