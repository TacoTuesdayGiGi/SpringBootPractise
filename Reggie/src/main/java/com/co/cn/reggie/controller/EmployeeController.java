package com.co.cn.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.co.cn.reggie.common.R;
import com.co.cn.reggie.entity.Employee;
import com.co.cn.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee employee1 = employeeService.getOne(queryWrapper);

        if (employee1 == null) {
            return R.error("用户不存在.");
        }
        if (!employee1.getPassword().equals(password)) {
            return R.error("密码错误.");
        }
        if (employee1.getStatus() == 0) {
            return R.error("账号不可用");
        }

        request.getSession().setAttribute("employee", employee1.getId());

        return R.success(employee1);
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return R.success("已注销.");
    }

    /**
     * 添加员工
     */
    @PostMapping()
    public R<String> save(@RequestBody Employee employee,HttpServletRequest request) {
        employee.setPassword(DigestUtils.md5DigestAsHex("user".getBytes()));
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        Long uid = (Long) request.getSession().getAttribute("employee");
        employee.setCreateUser(uid);
        employee.setUpdateUser(uid);
        employeeService.save(employee);
        return R.success("新增员工成功.");
    }
}
