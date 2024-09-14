package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Repair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepairMapper extends BaseMapper<Repair> {
}
