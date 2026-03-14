package com.aydog4nn.repository;

import com.aydog4nn.jwt.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {

        Optional<RefreshToken> findByRefreshToken(String refreshToken);

}
