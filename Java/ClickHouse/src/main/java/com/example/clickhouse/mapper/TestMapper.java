package com.example.clickhouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.clickhouse.entity.Test;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lsh
* @description 针对表【test】的数据库操作Mapper
* @createDate 2023-09-25 20:08:32
* @Entity entity.domain.Test
*/
@Mapper
public interface TestMapper extends BaseMapper<Test> {


}
