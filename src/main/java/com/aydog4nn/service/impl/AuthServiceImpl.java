package com.aydog4nn.service.impl;


import com.aydog4nn.dto.DtoUser;
import com.aydog4nn.jwt.AuthRequest;
import com.aydog4nn.jwt.AuthResponse;
import com.aydog4nn.jwt.JwtService;
import com.aydog4nn.jwt.RefreshToken;
import com.aydog4nn.model.User;
import com.aydog4nn.repository.RefreshTokenRepository;
import com.aydog4nn.repository.UserRepository;
import com.aydog4nn.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() +  1000*60*60*4));
        refreshToken.setUser(user);

        return refreshToken;
    }

    @Override
    public DtoUser register(AuthRequest request) {
        User user = new User();
        DtoUser dto = new DtoUser();


        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser =  userRepository.save(user);
        BeanUtils.copyProperties(savedUser,dto);

        return dto;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {

        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword());
            authenticationProvider.authenticate(auth);

            Optional<User> optionalUser =  userRepository.findByUsername(request.getUsername());
            String accessToken =  jwtService.GenerateToken(optionalUser.get());

            RefreshToken refreshToken = createRefreshToken(optionalUser.get());
            refreshTokenRepository.save(refreshToken);

            return  new AuthResponse(accessToken,refreshToken.getRefreshToken());

        }catch (Exception e) {
            System.out.println("Kullanıcı adı veya şifre hatalı");
        }

        return null;
    }
}
