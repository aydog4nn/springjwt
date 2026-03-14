package com.aydog4nn.service;

import com.aydog4nn.jwt.AuthResponse;
import com.aydog4nn.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
