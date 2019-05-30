package com.xujiang.xujiang.event.e2;

import com.xujiang.xujiang.XuProperties;
import com.xujiang.xujiang.event.DictEvent;
import com.xujiang.xujiang.listen.ListenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Slf4j
@ConditionalOnProperty(value = "dict.option",havingValue = "event")
public class TestListener2 implements ApplicationListener<DictEvent> {
    @Autowired
    ListenerService listenerService;
    public static final String KEY = "dict";

    @Override
    public void onApplicationEvent(DictEvent event) {
        log.info("listener {} stand by {}", this.getClass().getName(), event.getSource());
        if (event.getSource() != null) {
            try {
                listenerService.writeJsonFileToMemory(KEY, new File(event.getSource().toString()));
            } catch (IOException e) {
                log.info("监听读取 处理上传的文件 出错");

            }
        }

    }
}
