package com.example.clickhouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.clickhouse.entity.Test;
import com.example.clickhouse.service.TestService;
import com.example.clickhouse.mapper.TestMapper;
import org.springframework.stereotype.Service;

/**
* @author lsh
* @description 针对表【test】的数据库操作Service实现
* @createDate 2023-09-25 20:08:32
*/
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test>
implements TestService {

}
