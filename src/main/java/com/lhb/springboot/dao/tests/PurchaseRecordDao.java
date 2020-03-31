package com.lhb.springboot.dao.tests;

import com.lhb.springboot.entity.tests.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:35 2020/3/20
 */
@Mapper
public interface PurchaseRecordDao {
    int insertPurchaseRecord(PurchaseRecordPo po);
}
