package org.lsh.projecttest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lsh.projecttest.entity.User;
import org.lsh.projecttest.service.UserService;
import org.lsh.projecttest.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}
