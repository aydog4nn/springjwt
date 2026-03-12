package com.aydog4nn.controller;

import com.aydog4nn.dto.DtoUser;
import com.aydog4nn.jwt.AuthRequest;
import com.aydog4nn.jwt.AuthResponse;

public interface IRestAuthController {

    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);

}
