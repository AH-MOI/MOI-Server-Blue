package com.dsm.moi.domains.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final SignatureAlgorithm signatureAlgorithm;
    private final Key KEY;

    @Autowired
    public JwtService(@Value("${TOKEN_SECURE_KEY:secure-key}") String secure_key) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secure_key);
        signatureAlgorithm = SignatureAlgorithm.HS256;
        KEY = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    }

    public String createToken(String studentId, int expiration) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject("token")
                .claim("studentId", studentId)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(signatureAlgorithm, KEY)
                .compact();
    }

    public String getStudentId(String token) {
        return Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("studentId", String.class);
    }

    public boolean isValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isNotTimeOut(String token) {
        try {
            Date now = new Date();
            Date expiration = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.after(now);
        } catch(Exception e) {
            return false;
        }
    }
}
