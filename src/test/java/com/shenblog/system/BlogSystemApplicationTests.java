package com.shenblog.system;

import com.shenblog.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;

import org.apache.tomcat.util.security.MD5Encoder;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class BlogSystemApplicationTests {

    @Autowired
    private SysUser sysUser;

    void contextLoads() {
    }

    @Test
    void passwordTest(){

    }

    public static void main(String[] args) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest("Dcjet888888".getBytes(StandardCharsets.UTF_8));
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < digest.length; i++){
                int val = ((int) digest[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            log.info(hexValue.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
