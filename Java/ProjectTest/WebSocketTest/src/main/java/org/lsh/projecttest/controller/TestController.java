package org.lsh.projecttest.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.lsh.projecttest.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lsh
 * @description:
 */
@RestController
public class TestController {

    @Resource
    UserMapper userMapper;

    @GetMapping("/test")
    public String test() {
        return JSONUtils.toJSONString(userMapper.selectById(1));
    }
}
