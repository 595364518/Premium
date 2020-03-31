package com.lhb.springboot.controller;

import com.lhb.springboot.service.tests.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 03:03 2020/3/20
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    String luaCmd = "local id = ARGV[1]\n"
            +"if id == tonumber(redis.call('hget','test_lua','id')) then return null end\n"
            +"return redis.call('hgetall','test_lua')\n";
    @GetMapping("/testBuy")
    public ModelAndView testPurchase(){
        return new ModelAndView("product/test");
    }
    @PostMapping("/buy")
    public Result buy(Long userId,Long productId,int quantity){
        boolean success = productService.purchaseRedis(userId, productId, quantity);
        String message = success?"抢购成功":"抢购失败";
        return new Result(success,message);
    }
    @GetMapping("/lua")
    @ResponseBody
    public Map<String,Object> lua(){
        Map<String,Object> map = new HashMap<>();
        String sha1 = null;
        Jedis jedis = null;
        try{
            jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
            if(sha1==null){
                sha1 = jedis.scriptLoad(luaCmd);
            }
            Object object =jedis.evalsha(sha1,0,"1");
            List<String> result = (ArrayList) object;
            if(result!=null){
                map.put("id",result.get(1));
                map.put("name",result.get(3));
                map.put("score",result.get(5));
            }else{
                map.put("msg","null");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (jedis!=null&&jedis.isConnected()){
                jedis.close();
            }
        }
        return map;
    }
    class Result{
        private boolean success;
        private String message;
        Result(){

        }
        Result(boolean success,String message){
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
