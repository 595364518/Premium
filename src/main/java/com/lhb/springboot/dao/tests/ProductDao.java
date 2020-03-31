package com.lhb.springboot.dao.tests;

import com.lhb.springboot.entity.tests.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:40 2020/3/20
 */
@Mapper
public interface ProductDao {
    ProductPo getProduct(Long id);
    int decreaseProduct(@Param("id")Long id,
                        @Param("quantity")int quantity);
}
