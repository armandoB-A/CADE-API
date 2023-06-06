package com.bcode.cade.config;

import com.bcode.cade.dto.AlumnoSaveBcodeDto;
import com.bcode.cade.entities.AlumnoBcode;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Component
public class JwtProvider {
    private String secret = "secretito";

    @PostConstruct
    public void init() {
        secret = Base64.getEncoder()
                .encodeToString(secret.getBytes());
    }

    public String createToken(AlumnoSaveBcodeDto user) {
        Map<String, Object> claims =
                Jwts.claims().setSubject(user.getNombreAlumno());
        claims.put("id", user.getId());
        Date now = new Date();
        Date expiration = new Date(now.getTime()
                + 3600 * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,
                        secret)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return " bad token";
        }
    }
}
