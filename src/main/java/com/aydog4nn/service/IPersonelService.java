package com.aydog4nn.service;

import com.aydog4nn.model.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonelService {

    Page<Personel> findAllPageable(Pageable pageable);

}
