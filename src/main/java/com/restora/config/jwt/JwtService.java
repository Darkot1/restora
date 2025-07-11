package com.restora.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Metodo para sobrecargar el metodo generateToken sin extraClaims
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // Metodo para generar la clave de firma a partir del secreto JWT
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        //Retorna el jwt    token generado
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSingIngKey(), SignatureAlgorithm.HS256)
                .compact();
    }   

    // Metodo para obtener el correo del usuario a partir del token
    public String getUserEmail(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // Metodo para obtener un claim específico del token
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Metodo para obtener todos los claims del token
    private Claims getAllClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(getSingIngKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("JWT token is invalid", e);
        }
    }

    // Metodo para generar la clave de firma a partir del secreto JWT
    private Key getSingIngKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Metodo para validar el token JWT
    public boolean validateToken(String token, UserDetails userDetails){
        final String userEmail = getUserEmail(token);
        return (userEmail.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Metodo para verificar si el token ha expirado
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    // Metodo para obtener la fecha de expiración del token
    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }
}
