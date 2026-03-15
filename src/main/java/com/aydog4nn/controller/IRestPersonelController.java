package com.aydog4nn.controller;

import com.aydog4nn.model.Personel;
import com.aydog4nn.utils.RestPageableRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRestPersonelController {

    public Page<Personel> findAllPageable(RestPageableRequest restPageableRequest);

}
