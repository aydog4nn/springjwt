package com.aydog4nn.service.impl;

import com.aydog4nn.model.Personel;
import com.aydog4nn.repository.PersonelRepository;
import com.aydog4nn.service.IPersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonelServiceImpl implements IPersonelService {

    @Autowired
    private PersonelRepository personelRepository;

    @Override
    public Page<Personel> findAllPageable(Pageable pageable) {
        return personelRepository.findAllPageable(pageable);
    }
}
