package com.aydog4nn.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    public static final String SECRET_KEY = "DOwvxmzu+UhKSZXhIqjCgaa6NsXuMzGtO5Rz0gvJ5SA=";


    public String GenerateToken(UserDetails userDetails){

        Map<String,Object> claimsMap = new HashMap<>();
        claimsMap.put("ROLE","ADMIN");

            return Jwts.builder().
            setSubject(userDetails.getUsername()).
            addClaims(claimsMap).
            setIssuedAt(new Date()).
            setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*2)).
            signWith(getKey(), SignatureAlgorithm.HS256).
            compact();

    }


    public Object getClaimsByKey(String token,String key){
        Claims claims = getClaims(token);
        return claims.get(key);
    }

    public Claims getClaims(String token){

        return Jwts.
                parserBuilder().
                setSigningKey(getKey()).
                build().
                parseClaimsJws(token).
                getBody();
    }


    public <T> T exportToken(String token, Function<Claims,T> claimsTFunction){
        Claims claims =  getClaims(token);
        return claimsTFunction.apply(claims);
    }

    public String getUsernameByToken(String token){
        return exportToken(token,Claims::getSubject);
    }

    public boolean isTokenExpired(String token){
         Date expiredDate = exportToken(token,Claims::getExpiration);
         return new Date().before(expiredDate);

    }


    public Key getKey() {
        byte[] keyBytes =  Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }

}
