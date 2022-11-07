package com.co.cn.reggie.dto;

import com.co.cn.reggie.entity.Setmeal;
import com.co.cn.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
