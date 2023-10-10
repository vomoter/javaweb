package com.example;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper usermapper;

    @Test
    public void testListUser() {
        List<User> userList =usermapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });

    }
}
