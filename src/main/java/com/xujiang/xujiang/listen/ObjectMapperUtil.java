package com.xujiang.xujiang.listen;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ObjectMapperUtil {


    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> T jsonFileToObject(File file, Class<T> clazz) {
        T readValue = null;

        try {
            readValue = objectMapper.readValue(file, clazz);
        } catch (IOException e) {
            log.warn("json 转对象出错");
//            throw new NWException(StatusEnum.ERROR_SERVER);
        }
        return readValue;
    }
}
