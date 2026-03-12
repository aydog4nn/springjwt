package com.aydog4nn.service;

import com.aydog4nn.dto.DtoUser;
import com.aydog4nn.jwt.AuthRequest;
import com.aydog4nn.jwt.AuthResponse;

public interface IAuthService
{

    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);

}
