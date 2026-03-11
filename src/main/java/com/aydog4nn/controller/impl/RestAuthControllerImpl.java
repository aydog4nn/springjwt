package com.aydog4nn.controller.impl;

import com.aydog4nn.controller.IRestAuthController;
import com.aydog4nn.dto.DtoUser;
import com.aydog4nn.jwt.AuthRequest;
import com.aydog4nn.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {

    @Autowired
    private IAuthService authService;


    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest request) {
        return authService.register(request);
    }
}
