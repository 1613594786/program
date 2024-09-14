package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.DormManager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DormManagerMapper extends BaseMapper<DormManager> {
}
