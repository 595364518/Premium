package com.lhb.springboot.service.tests.impl;

import com.lhb.springboot.dao.tests.ProductDao;
import com.lhb.springboot.dao.tests.PurchaseRecordDao;
import com.lhb.springboot.entity.tests.ProductPo;
import com.lhb.springboot.entity.tests.PurchaseRecordPo;
import com.lhb.springboot.service.tests.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;


/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:49 2020/3/20
 */
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ProductDao productDao;
    @Autowired
    PurchaseRecordDao purchaseRecordDao;
    String purchaseScript =
            //先将产品编号保存到集合中
            "redis.call('sadd',KEYS[1],ARGV[2])\n"
            //购买列表
            +"local productPurchaseList = KEYS[2]..ARGV[2]\n"
            //用户编号
            +"local userId = ARGV[1]\n"
            //产品键
            +"local product = 'product_'..ARGV[2]\n"
            //购买数量
            +"local quantity = tonumber(ARGV[3])\n"
            //当前库存
            +"local stock = tonumber(redis.call('hget',product,'stock'))\n"
            //价格
            +"local price = tonumber(redis.call('hget',product,'price'))\n"
            //购买时间
            +"local purchase_date = ARGV[4]\n"
            //库存不足，返回0
            +"if stock < quantity then return 0 end\n"
            //减库存
            +"stock = stock - quantity\n"
            +"redis.call('hset',product,'stock',tostring(stock))\n"
            //计算价格
            +"local sum = price * quantity\n"
            //合并购买记录数据
            +"local purchaseRecord = userId..','..quantity..','"
            +"..sum..','..price..','..purchase_date\n"
            //将构面记录保存到list里面
            +"redis.call('rpush',productPurchaseList,purchaseRecord)\n"
            //返回成功
            +"return 1\n";
    //Redis购买记录集合前缀
    private static final String PURCHASE_PRODUCT_LIST = "purchase_list_";
    //抢购商品集合
    private static final String PRODUCT_SCHEDULE_SET = "product_schedule_set";
    //32位SHAl编码，第一次执行的时候先让Redis进行缓存脚本返回
    private String shal = null;

    @Override
    public boolean purchaseRedis(Long userId, Long productId, int quantity) {
        Long purchaseDate = System.currentTimeMillis();
        Jedis jedis = null;
        try {
            jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
            //如果没有加载过，则先将脚本加载到Redis服务器，让其返回shal
            if (shal == null) {
                shal = jedis.scriptLoad(purchaseScript);
            }
            //执行脚本，返回结果
            Object res = jedis.evalsha(shal, 2, PRODUCT_SCHEDULE_SET,
                    PURCHASE_PRODUCT_LIST, userId + "", productId + "",
                    quantity + "", purchaseDate + "");
            Long result = (Long) res;
            return result == 1;
        }finally {
            if(jedis!=null&&jedis.isConnected()){
                jedis.close();
            }
        }
    }

    @Override
    //当运行方法启用新的独立事务运行
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean dealRedisPurchase(List<PurchaseRecordPo> poList) {
        for(PurchaseRecordPo po:poList){
            purchaseRecordDao.insertPurchaseRecord(po);
            productDao.decreaseProduct(po.getProductId(),po.getQuantity());
        }
        return true;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean purchase(Long userId, Long productId, int quantity) {
        ProductPo product = productDao.getProduct(productId);
        if(product.getStock() < quantity){

            return false;
        }
        productDao.decreaseProduct(productId,quantity);
        PurchaseRecordPo po = this.init(userId,product,quantity);
        purchaseRecordDao.insertPurchaseRecord(po);
        return true;
    }
    public PurchaseRecordPo init(Long userId,ProductPo product,int quantity){
        PurchaseRecordPo po = new PurchaseRecordPo();
        po.setUserId(userId);
        po.setNote("购买日志:"+System.currentTimeMillis());
        po.setPrice(product.getPrice());
        po.setProductId(product.getId());
        po.setQuantity(quantity);
        po.setSum(product.getPrice()*quantity);
        return po;
    }
}
