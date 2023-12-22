package com.jingdong.reggiepro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdong.reggiepro.common.R;
import com.jingdong.reggiepro.entity.Employee;
import com.jingdong.reggiepro.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*") //解决跨域
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request,@RequestBody Employee employee){
//        1、拿到用户输入的姓名和密码
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());//m5加密
//            2、根据用户名查数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee employ =  employeeService.getOne(queryWrapper);
        System.out.println(employ);
        if(employ == null){
            return R.error("登录失败");
        }

        if(!employ.getPassword().equals(password)){
            return R.error("登录失败");
        }
        if(employ.getStatus() == 0){
            return R.error("账号已禁用");
        }

        //登录成功后,将用户id存入session
        request.getSession().setAttribute("employee",employ.getId());
        return  R.success(employ);
    }

    @PostMapping("/logout")
    public R<String> login(HttpServletRequest request){

        //登录成功后,将用户id存入session
        request.getSession().removeAttribute("employee");
        return  R.success("退出成功");
    }
}
