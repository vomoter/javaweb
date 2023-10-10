package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    //生成JWT
    @Test
    public void testJWb() {
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("id", 1);
        stringObjectMap.put("name", "tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "example")
                .setClaims(stringObjectMap) //自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("example")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5NjkzMDM0OH0.pUTHIPnKuw4S7gMrFb8c6Qjayua70E2fhD62h6lwS8s")
                .getBody();
        System.out.println(claims);
    }
}
