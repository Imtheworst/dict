package com.xujiang.xujiang.listen;

import com.xujiang.xujiang.DictionaryService;
import com.xujiang.xujiang.entity.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CacheConfig(cacheNames = "redis")
@Service
public class ListenerService {

    @Autowired
    DictionaryService dictionaryService;
    public List<Dict> writeJsonFileToMemory(String key, File file) throws IOException {

        List<Dict> put = dictionaryService.put(key, file);
        return put;
    }

    public void clear(String key) {
        dictionaryService.clear(key);

    }

}
