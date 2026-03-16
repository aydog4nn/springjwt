package com.aydog4nn.service;

import com.aydog4nn.dto.DtoPersonel;
import com.aydog4nn.model.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonelService {

    Page<Personel> findAllPageable(Pageable pageable);

    List<DtoPersonel> toDTOList(List<Personel> personelList);

}
