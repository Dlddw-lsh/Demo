package org.lsh.projecttest;

import org.junit.jupiter.api.Test;
import org.lsh.projecttest.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ProjectTestApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectList(null));
    }

}
