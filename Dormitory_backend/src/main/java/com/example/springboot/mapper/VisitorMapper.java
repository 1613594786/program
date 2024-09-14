package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Visitor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitorMapper extends BaseMapper<Visitor> {
}
