package vn.com.ltdt.finwise.security;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.shaded.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.com.ltdt.finwise.entities.AppUser;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class JwtProvider {

    @Value("${secret_key}")
    private String secret_key;

    public String generateToken(AppUser user) throws JOSEException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime expirationDate = currentDateTime.plusDays(1);

        JWSSigner signer = new MACSigner(secret_key);


        JWSObject jwsObject = createJWTObject(user, expirationDate, currentDateTime);

        jwsObject.sign(signer);
        String s = jwsObject.serialize();
        log.info("JWT generated : {}", s);
        return s;
    }

    private JWSObject createJWTObject(AppUser user, LocalDateTime expirationDate, LocalDateTime currentDateTime) {
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("userId", user.getUserId());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("role", user.getRoles().getFirst().getName());
        jsonObject.put("exp", expirationDate.toString());
        jsonObject.put("iat", currentDateTime.toString());
        jsonObject.put("isEnable", user.isEnabled() ? "true" : "false");

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        Payload payload = new Payload(jsonObject.toString());
        return new JWSObject(header,payload);
    }

    public String getUsernameFromToken(String token) throws ParseException {
        JWSObject jwsObject = JWSObject.parse(token);
        Payload payload = jwsObject.getPayload();
        Map<String,Object> jsonObject =  payload.toJSONObject();
        return jsonObject.get("email").toString();
    }

    public boolean validateToken(String token) {
        try{
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier verifier = new MACVerifier(secret_key);
            jwsObject.verify(verifier);
            return true;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
