package com.aydog4nn.controller.impl;

import com.aydog4nn.controller.IRestPersonelController;

import com.aydog4nn.dto.DtoPersonel;
import com.aydog4nn.model.Personel;
import com.aydog4nn.service.IPersonelService;
import com.aydog4nn.utils.RestPageableEntity;
import com.aydog4nn.utils.RestPageableRequest;
import com.aydog4nn.utils.RestRootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/personel")
@RestController
public class RestPersonelControllerImpl extends RestBaseController implements IRestPersonelController {

    @Autowired
    private IPersonelService personelService;

    @GetMapping("/pageable")
    @Override
    public RestRootEntity<RestPageableEntity<DtoPersonel>>  findAllPageable(RestPageableRequest restPageableRequest) {
        Page<Personel> page = personelService.findAllPageable(toPageable(restPageableRequest));
        RestPageableEntity<DtoPersonel> pageableResponse = toPageableResponse(page,personelService.toDTOList(page.getContent()));
        return ok(pageableResponse);
    }
}
