package com.shenblog.system;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
//@SpringBootTest
class BlogSystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void passwordTest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123");
        log.info(encode);
    }

}
