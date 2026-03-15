package com.aydog4nn.controller.impl;

import com.aydog4nn.utils.PagerUtil;
import com.aydog4nn.utils.RestPageableRequest;
import org.springframework.data.domain.Pageable;

public class RestBaseController {

    public Pageable toPageable(RestPageableRequest restPageableRequest){
        return PagerUtil.toPageable(restPageableRequest);
    }
}
