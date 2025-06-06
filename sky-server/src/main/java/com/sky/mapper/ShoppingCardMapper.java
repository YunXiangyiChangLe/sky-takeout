package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCardMapper {
    /**
     * 查询用户的购物车
     * @param shoppingCartDTO
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCartDTO);

    @Update("update shopping_cart set number=#{number} where id=#{id}")
    void updateNumberById(ShoppingCart shoppingCart);


    /**
     * 添加购物车数据
     * @param shoppingCart
     */
    @Insert("insert into shopping_cart (name, image, user_id, dish_id, setmeal_id, " +
            "dish_flavor, number, amount, create_time)" +
            "values (#{name},#{image},#{userId},#{dishId},#{setmealId}," +
            "#{dishFlavor},#{number},#{amount},#{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 根据id删除数据
     * @param id
     */
    @Delete("delete from shopping_cart where id=#{id}")
    void deleteById(@Param("id") Long id);

    /**
     * userId
     * @param userId
     */
    @Delete("delete from shopping_cart where user_id=#{userId}")
    void deleteByUserId(@Param("userId") Long userId);

    /**
     * 批量插入数据
     * @param shoppingCartList
     */
    void insertBatch(List<ShoppingCart> shoppingCartList);
}
