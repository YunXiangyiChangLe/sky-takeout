package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {


    /**
     * 根据菜品id查套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealsByDishIds(@Param("dishIds") List<Long> dishIds);
}
