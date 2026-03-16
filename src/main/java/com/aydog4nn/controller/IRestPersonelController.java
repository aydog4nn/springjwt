package com.aydog4nn.controller;

import com.aydog4nn.dto.DtoPersonel;
import com.aydog4nn.model.Personel;
import com.aydog4nn.utils.RestPageableEntity;
import com.aydog4nn.utils.RestPageableRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRestPersonelController {

    public RestPageableEntity<DtoPersonel> findAllPageable(RestPageableRequest restPageableRequest);

}
