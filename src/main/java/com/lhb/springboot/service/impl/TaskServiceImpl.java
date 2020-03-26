package com.lhb.springboot.service.impl;

import com.lhb.springboot.entity.PurchaseRecordPo;
import com.lhb.springboot.service.ProductService;
import com.lhb.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 05:15 2020/3/20
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ProductService productService;
    private static final String PRODUCT_SCHEDULE_SET = "product_schedule_set";
    private static final String PURCHASE_PRODUCT_LIST = "purchase_list_";
    //每次取出1000条，避免一次取出消耗太多内存
    private static final int ONE_TIME_SIZE = 1000;
    @Override
    //每天凌晨一点钟开始执行任务
    //@Scheduled(fixedRate = 1000*60)
    public void purchaseTask() {
        Set<String> productIdList =
                stringRedisTemplate.opsForSet().members(PRODUCT_SCHEDULE_SET);
        List<PurchaseRecordPo> poList = new ArrayList<>();
        for(String productIdStr:productIdList){
            Long productId = Long.parseLong(productIdStr);
            String purchaseKey = PURCHASE_PRODUCT_LIST + productId;
            BoundListOperations<String,String> ops =
                    stringRedisTemplate.boundListOps(purchaseKey);
            //计算记录数
            long size = stringRedisTemplate.opsForList().size(purchaseKey);
            Long times = size%ONE_TIME_SIZE == 0?
                    size / ONE_TIME_SIZE:size / ONE_TIME_SIZE+1;
            for (int i = 0;i < times;i++){
                //获取至多TIME_SIZE个抢红包信息
                List<String> prList = null;
                if(i == 0){
                    prList = ops.range(i * ONE_TIME_SIZE,(i+1)*ONE_TIME_SIZE);
                }else{
                    prList = ops.range(i*ONE_TIME_SIZE+1,(i+1)*ONE_TIME_SIZE);
                }
                for (String prStr:prList){
                    PurchaseRecordPo po =
                            this.createPurchaseRecord(productId,prStr);
                    poList.add(po);
                }
                try{
                    productService.dealRedisPurchase(poList);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                //清空列表，等待重新写入数据
                poList.clear();
            }
            //删除购买列表
            stringRedisTemplate.delete(purchaseKey);
            //从商品集合中删除商品
            stringRedisTemplate.opsForSet()
                    .remove(PRODUCT_SCHEDULE_SET,productIdStr);
        }
    }
    private PurchaseRecordPo createPurchaseRecord(
            Long productId,String prStr){
        String[] arr = prStr.split(",");
        Long userId = Long.parseLong(arr[0]);
        int quantity = Integer.parseInt(arr[1]);
        double sum = Double.valueOf(arr[2]);
        double price = Double.valueOf(arr[3]);
        Long time = Long.parseLong(arr[4]);
        Timestamp purchaseTime = new Timestamp(time);
        PurchaseRecordPo po = new PurchaseRecordPo();
        po.setProductId(productId);
        po.setPurchaseDate(purchaseTime);
        po.setQuantity(quantity);
        po.setSum(sum);
        po.setUserId(userId);
        po.setNote("购买日志："+purchaseTime.getTime());
        return po;
    }
}
