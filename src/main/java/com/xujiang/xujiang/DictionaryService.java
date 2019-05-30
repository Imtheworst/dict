package com.xujiang.xujiang;

import com.xujiang.xujiang.entity.Dict;
import com.xujiang.xujiang.entity.Dictionary;
import com.xujiang.xujiang.listen.ObjectMapperUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@CacheConfig(cacheNames = "redis")
public class DictionaryService {

    @CachePut(key = "#key")
    public List<Dict> put(final String key, final File file) {
        Dictionary dict = ObjectMapperUtil.jsonFileToObject(file, Dictionary.class);
        return dict.getDict();

    }

    @Cacheable
    public List<Dict> get(final String key) {
        return new Dictionary().getDict();
    }

    @CacheEvict
    public void clear(final String key) {

    }
}