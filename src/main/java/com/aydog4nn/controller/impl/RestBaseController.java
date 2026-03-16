package com.aydog4nn.controller.impl;

import com.aydog4nn.dto.DtoPersonel;
import com.aydog4nn.utils.PagerUtil;
import com.aydog4nn.utils.RestPageableEntity;
import com.aydog4nn.utils.RestPageableRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestBaseController {

    public Pageable toPageable(RestPageableRequest restPageableRequest){
        return PagerUtil.toPageable(restPageableRequest);
    }


    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content) {
        return PagerUtil.toPageableResponse(page,content);
    }

}
