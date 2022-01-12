package com.example.kehou.service.system;

import com.example.kehou.common.exception.job.TokenException;
import com.example.kehou.service.impl.UserServiceImpl;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

/**
 * @author ShuangLXan
 * @date 2021/11/24 10:00
 */
@Slf4j
@Service
public class TokenService {
    /**
     * 创建秘钥
     * todo:从数据库获取
     */
    private static final byte[] SECRET = "6MNSobBRCHGIO0fS6MNSobBRCHGIO0fS".getBytes();

    /**
     * 过期时间5秒
     */
    private static final long EXPIRE_TIME = 1000 * 5;


    /**
     * 生成Token
     *
     * @param account 用户UserName
     * @return 具体token
     */
    public String createToken(String account) {
        try {
            /**
             * 1.创建一个32-byte的密匙
             */
            MACSigner macSigner = new MACSigner(SECRET);
            /**
             * 2. 建立payload 载体
             * iss (发行者)、exp (过期时间)、sub (主题)、aud (受众)
             */
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
//                    .subject("token")
                    .issuer("lian")
                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .claim("ACCOUNT", account)
                    .build();

            /**
             * 3. 建立签名
             */
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(macSigner);

            /**
             * 4. 生成token
             */
            String token = signedJWT.serialize();
            return token;
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验token
     *
     * @param token 待验证token
     */
    public String validToken(String token) {
        try {
            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET);
            //校验是否有效
            if (!jwt.verify(verifier)) {
                throw new TokenException("Token 无效");
            }

            //校验超时
//            Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
//            if (new Date().after(expirationTime)) {
//                throw new TokenException("Token 已过期");
//            }

            //获取载体中的数据
            Object account = jwt.getJWTClaimsSet().getClaim("ACCOUNT");
            //是否有openUid
            if (Objects.isNull(account)) {
                throw new TokenException("账号为空");
            }
            return account.toString();

        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }

}
