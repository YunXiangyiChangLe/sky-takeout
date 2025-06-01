package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.Dish;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.mapper.ShoppingCardMapper;
import com.sky.service.ShoppingCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ShoppingCardServiceImpl implements ShoppingCardService {
    @Autowired
    private ShoppingCardMapper shoppingCardMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;
    /**
     * 添加购物车
     * @param shoppingCartDTO
     */
    @Override
    public void addShoppingCard(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);
        List<ShoppingCart> list = shoppingCardMapper.list(shoppingCart);

        if(list!=null && !list.isEmpty()){
            ShoppingCart cart = list.get(0);
            cart.setNumber(cart.getNumber()+1);
            shoppingCardMapper.updateNumberById(cart);
        }else {
            Long dishId = shoppingCartDTO.getDishId();
            Long setmealId = shoppingCartDTO.getSetmealId();
            if(dishId!=null){
                Dish dish=dishMapper.getById(dishId);
                shoppingCart.setName(dish.getName());
                shoppingCart.setImage(dish.getImage());
                shoppingCart.setAmount(dish.getPrice());
                shoppingCart.setNumber(1);
                shoppingCart.setCreateTime(LocalDateTime.now());
            }else{
                log.error("暂时不能添加套餐");
            }
        }
        shoppingCardMapper.insert(shoppingCart);
    }

    /**
     * 查看购物车
     * @return
     */
    @Override
    public List<ShoppingCart> showShoppingCard() {
        Long currentId = BaseContext.getCurrentId();
        ShoppingCart list = ShoppingCart.builder().userId(currentId).build();
        return shoppingCardMapper.list(list);
    }

    /**
     * 删除购物车商品
     * @param shoppingCartDTO
     */
    @Override
    public void subShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);
        List<ShoppingCart> list = shoppingCardMapper.list(shoppingCart);
        if(list!=null && !list.isEmpty()){
            ShoppingCart cart = list.get(0);
            if(cart.getNumber()==1){
                shoppingCardMapper.deleteById(cart.getId());
            }else {
                cart.setNumber(cart.getNumber()-1);
                shoppingCardMapper.updateNumberById(cart);
            }
        }
    }

    @Override
    public void clean() {
        Long currentId = BaseContext.getCurrentId();
        shoppingCardMapper.deleteByUserId(currentId);
    }
}
