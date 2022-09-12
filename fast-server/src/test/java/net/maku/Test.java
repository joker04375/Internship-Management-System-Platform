package net.maku;

import net.maku.framework.common.utils.PasswordEncoder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {
    @org.junit.jupiter.api.Test
    public void generateUser(){
        String username = "test";
        String password = "123";
        String encode = PasswordEncoder.encode("123");
        System.out.println(encode);
    }
}

