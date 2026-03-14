package com.aydog4nn.service.impl;

import com.aydog4nn.jwt.AuthResponse;
import com.aydog4nn.jwt.JwtService;
import com.aydog4nn.jwt.RefreshToken;
import com.aydog4nn.jwt.RefreshTokenRequest;
import com.aydog4nn.model.User;
import com.aydog4nn.repository.RefreshTokenRepository;
import com.aydog4nn.service.IRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private JwtService jwtService;

    public boolean isRefreshTokenExpired(Date expiredDate){
        return new Date().before(expiredDate);
    }

    public RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() +  1000*60*60*4));
        refreshToken.setUser(user);

        return refreshToken;
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {

         Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(refreshTokenRequest.getRefreshToken());
         if (optional.isEmpty()){
             System.out.println("Refresh Token geçersizdir.");
         }

         RefreshToken refreshToken =  optional.get();

         if (!isRefreshTokenExpired(refreshToken.getExpireDate())) {
             System.out.println("Refresh Token expire olmuştur.");
         }

         String accessToken = jwtService.GenerateToken(refreshToken.getUser());
         RefreshToken savedRefreshToken =  refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));

        return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());
    }
}
