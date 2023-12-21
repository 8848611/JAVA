package com.jingdong.reggiepro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdong.reggiepro.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
