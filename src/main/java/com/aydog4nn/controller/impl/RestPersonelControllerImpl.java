package com.aydog4nn.controller.impl;

import com.aydog4nn.controller.IRestPersonelController;

import com.aydog4nn.model.Personel;
import com.aydog4nn.service.IPersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/personel")
@RestController
public class RestPersonelControllerImpl implements IRestPersonelController {

    @Autowired
    private IPersonelService personelService;

    @GetMapping("/pageable")
    @Override
    public Page<Personel> findAllPageable(@RequestParam(value = "pageNumber") int pageNumber,
                                          @RequestParam(value = "pageSize")  int pageSize) {

        PageRequest pageRequest =  PageRequest.of(pageNumber,pageSize);
        return personelService.findAllPageable(pageRequest);
    }
}
