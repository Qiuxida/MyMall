package com.star.mall.base.model;

import cn.hutool.json.JSONUtil;
import com.star.mall.persistence.entity.OperationLog;
import com.star.mall.persistence.service.IOperationLogService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * kafka消费者
 * @author StarQ
 * @since 2021-3-10
 */
@Component
public class KafkaConsumer {

    @Resource
    IOperationLogService operationLogService;

    @KafkaListener(topics = {"opr-log"})
    public void onMessage(ConsumerRecord<String, String> record){
        OperationLog log = JSONUtil.toBean(record.value(), OperationLog.class);
        operationLogService.save(log);
    }

    @KafkaListener(topics = {"err-log"})
    public void onErrorMessage(ConsumerRecord<String, String> record) {

    }
}
