package com.shenjinxiang.spb.rpc;

import com.shenjinxiang.spb.rpc.entity.RpcResult;
import com.shenjinxiang.spb.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/9 16:53
 */
@Component
public class Start implements CommandLineRunner {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start...");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 18);
        map.put("address", "北京");
        map.put("date", new Date());
        RpcResult rpcResult = new RpcResult();
        rpcResult.setSuccess(true);
        rpcResult.setMsg("OK");
        rpcResult.setResult(map);
        redisUtil.set("rpc01", rpcResult);
        RpcResult rpcResult1 = (RpcResult) redisUtil.get("rpc01");
        System.out.println(rpcResult1.getMsg());
        System.out.println(rpcResult1.getResult());
    }
}
