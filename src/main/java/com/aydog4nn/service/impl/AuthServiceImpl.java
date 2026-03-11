package com.aydog4nn.service.impl;


import com.aydog4nn.dto.DtoUser;
import com.aydog4nn.jwt.AuthRequest;
import com.aydog4nn.model.User;
import com.aydog4nn.repository.UserRepository;
import com.aydog4nn.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
}
