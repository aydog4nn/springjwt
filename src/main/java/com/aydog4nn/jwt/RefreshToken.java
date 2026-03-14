package com.aydog4nn.jwt;

import com.aydog4nn.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "refresh_token")
        private String refreshToken;

        @Column(name = "expire_date")
        private Date expireDate;

        @ManyToOne
        private User user;

}
