package com.aydog4nn.service;

import com.aydog4nn.dto.DtoUser;
import com.aydog4nn.jwt.AuthRequest;

public interface IAuthService
{

    public DtoUser register(AuthRequest request);

}
