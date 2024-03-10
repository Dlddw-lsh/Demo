package org.lsh.projecttest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lsh.projecttest.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
