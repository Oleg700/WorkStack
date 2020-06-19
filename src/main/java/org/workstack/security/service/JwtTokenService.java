package org.workstack.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtTokenService {

    public static final String KEY_SECRET = "workstack";

    //1 hour
    public static final long JWT_TOKEN_EXPIRATION_IN_MILLISECONDS = 3600000;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token,
                                    Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(KEY_SECRET).parseClaimsJws(token).getBody();
    }


    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis()
                        + JWT_TOKEN_EXPIRATION_IN_MILLISECONDS))
                .signWith(SignatureAlgorithm.HS512, KEY_SECRET).compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    private Boolean isTokenExpired(String token) {
        Date date = getExpirationDateFromToken(token);
        System.out.println(date);
        return date.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
}
