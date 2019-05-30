package com.xujiang.xujiang;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:xu.properties")

public class XuProperties {




    @Value("${watch.dict}")
    public String WATCH_DICT;

    @Value("${upload.file.dict}")
    public String UPLOAD_FILE_DICT;

}
