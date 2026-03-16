package com.aydog4nn.service.impl;

import com.aydog4nn.dto.DtoDepartment;
import com.aydog4nn.dto.DtoPersonel;
import com.aydog4nn.model.Personel;
import com.aydog4nn.repository.PersonelRepository;
import com.aydog4nn.service.IPersonelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonelServiceImpl implements IPersonelService {

    @Autowired
    private PersonelRepository personelRepository;

    @Override
    public Page<Personel> findAllPageable(Pageable pageable) {
        return personelRepository.findAllPageable(pageable);
    }

    @Override
    public List<DtoPersonel> toDTOList(List<Personel> personelList) {

        List<DtoPersonel> dtoPersonelList = new ArrayList<>();

        for (Personel personel : personelList){
            DtoPersonel dtoPersonel = new DtoPersonel();
            DtoDepartment dtoDepartment = new DtoDepartment();

            BeanUtils.copyProperties(personel,dtoPersonel);
            BeanUtils.copyProperties(personel.getDepartment(),dtoDepartment);

            dtoPersonel.setDepartment(dtoDepartment);
            dtoPersonelList.add(dtoPersonel);
        }
        return dtoPersonelList;
 
    }
}
