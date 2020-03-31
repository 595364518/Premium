package com.lhb.springboot.service.tests;

import com.lhb.springboot.entity.tests.PurchaseRecordPo;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:47 2020/3/20
 */
public interface ProductService {
    boolean purchase(Long userId,Long productId,int quantity);
    boolean purchaseRedis(Long userId,Long productId,int quantity);
    boolean dealRedisPurchase(List<PurchaseRecordPo> poList);
}
