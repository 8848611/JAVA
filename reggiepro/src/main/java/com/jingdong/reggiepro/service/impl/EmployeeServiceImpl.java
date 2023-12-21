package com.jingdong.reggiepro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jingdong.reggiepro.entity.Employee;
import com.jingdong.reggiepro.mapper.EmployeeMapper;
import com.jingdong.reggiepro.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{


}
