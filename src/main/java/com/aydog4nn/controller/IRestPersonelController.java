package com.aydog4nn.controller;

import com.aydog4nn.model.Personel;
import org.springframework.data.domain.Page;

public interface IRestPersonelController {

    public Page<Personel> findAllPageable(int pageNumber, int pageSize);

}
