package com.xujiang.xujiang;

import com.xujiang.xujiang.entity.Dict;
import com.xujiang.xujiang.event.DictEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class Testcontroller {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/1")
    public List<Dict> getDict() {

        List<Dict> dict = dictionaryService.get("dict");
        return dict;
    }

    @Autowired
    XuProperties properties;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/2")
    public String  uploadFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        if (!multipartFile.isEmpty()) {
            String s = properties.UPLOAD_FILE_DICT + "/" + multipartFile.getOriginalFilename();
            File dest = new File(s);
            try {
                multipartFile.transferTo(dest);
            } catch (IOException e) {
                log.error("上传文件保存本地出错");
            }

            ApplicationEvent event = new DictEvent(s);
            publisher.publishEvent(event);
            return "ok";
        }
        return "no ok";

    }

}

