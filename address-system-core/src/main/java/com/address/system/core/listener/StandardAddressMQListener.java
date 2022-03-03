package com.address.system.core.listener;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.address.system.core.dao.StandardAddressESRepository;
import com.address.system.core.entity.standardAddress.StandardAddressESEntity;
import com.address.system.core.utils.JsonConvertUtils;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过rocketmq同步address表的mysql数据到es
 */
@Component
@RocketMQMessageListener(
    topic = "standard_address",
    consumerGroup = "standard_address",
    selectorExpression = "*",
    consumeMode = ConsumeMode.ORDERLY,
    messageModel = MessageModel.CLUSTERING,
    consumeThreadMax = 1
)
public class StandardAddressMQListener implements RocketMQListener<String> {
    @Autowired
    private StandardAddressESRepository standardAddressEsRepository;

    @Override
    public void onMessage(String msg) {
        if(! JSONUtil.isJson(msg)){
            return;
        }
        JSONObject msgJsonObject = JSONUtil.parseObj(msg);
        System.out.println("接收到消息 -> " + msgJsonObject.toStringPretty());
        String sqlType = msgJsonObject.getStr("type");
        switch (sqlType) {
            case "UPDATE":
            case "INSERT":
                JSONArray data = msgJsonObject.getJSONArray("data");
                System.out.println("原始sql信息 -> " + data.toStringPretty());
                List<StandardAddressESEntity> entites = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    JSONObject object = data.getJSONObject(i);
                    JsonConvertUtils.convert(object);
                    System.out.println("转换为entity字段信息 -> " + object.toStringPretty());
                    StandardAddressESEntity entity = JSONUtil.toBean(object,StandardAddressESEntity.class);
                    switch(String.valueOf(object.get("status"))){
                        case "1":
                            entity.setStatus("uncommitted");
                            break;
                        case "2":
                            entity.setStatus("committed");
                            break;
                        case "3":
                            entity.setStatus("Approving");
                            break;
                        case "4":
                            entity.setStatus("Approved");
                            break;
                        default:
                            entity.setStatus("");
                            break;
                    }
                    entity.setYn("1".equals(object.get("yn")));
                    System.out.println("转换为entity -> " + entity);
                    entites.add(entity);
                }
                try {
                    standardAddressEsRepository.saveAll(entites);
                }catch(Exception e){
                    System.out.println("投递失败" + e.getMessage());
                }
                break;
            case "DELETE":
            default:
                System.out.println("不同步的消息类型：" + sqlType);
                break;
        }
    }
}
