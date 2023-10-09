package com.example.clickhouse;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.clickhouse.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ClickHouseApplicationTests {
    @Resource
    TestService testService;
    @Test
    void contextLoads() {
        Page<com.example.clickhouse.entity.Test> page = new Page<>(1,1);
        System.out.println(testService.page(page).getRecords());
        testService.save(new com.example.clickhouse.entity.Test(1,"99999"));
    }

}
