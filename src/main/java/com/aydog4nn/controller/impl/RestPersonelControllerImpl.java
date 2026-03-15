package com.aydog4nn.controller.impl;

import com.aydog4nn.controller.IRestPersonelController;

import com.aydog4nn.model.Personel;
import com.aydog4nn.service.IPersonelService;
import com.aydog4nn.utils.RestPageableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/personel")
@RestController
public class RestPersonelControllerImpl extends RestBaseController implements IRestPersonelController {

    @Autowired
    private IPersonelService personelService;

    @GetMapping("/pageable")
    @Override
    public Page<Personel> findAllPageable(RestPageableRequest restPageableRequest) {
        Pageable pageableRequest = toPageable(restPageableRequest);
        return personelService.findAllPageable(pageableRequest);
    }
}
