package com.co.cn.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.co.cn.reggie.common.R;
import com.co.cn.reggie.entity.Employee;
import com.co.cn.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public R<String> save(@RequestBody Employee employee, HttpServletRequest request) {
        employee.setPassword(DigestUtils.md5DigestAsHex("user".getBytes()));
//        employee.setCreateTime(new Date());
//        employee.setUpdateTime(new Date());
        String uid = (String) request.getSession().getAttribute("employee");
//        employee.setCreateUser(uid);
//        employee.setUpdateUser(uid);

        employeeService.save(employee);

        return R.success("新增员工成功.");
    }

    /**
     * 员工信息分页查询
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page<Employee>> page(int page, int pageSize, String name) {
        log.info("page = {},pageSize = {},name = {}", page, pageSize, name);

        //构造分页构造器
        Page<Employee> pageInfo = new Page<Employee>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        //执行查询
        employeeService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }


    /**
     * 根据id修改员工信息
     *
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Employee employee) {
        log.info(employee.toString());

        String empId = (String) request.getSession().getAttribute("employee");
//        employee.setUpdateTime(new Date());
//        employee.setUpdateUser(empId);
        employeeService.updateById(employee);

        return R.success("员工信息修改成功");
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable String id){
        log.info("根据id查询员工信息...");
        Employee employee = employeeService.getById(id);
        if(employee != null){
            return R.success(employee);
        }
        return R.error("没有查询到对应员工信息");
    }
}
