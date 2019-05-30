package com.xujiang.xujiang.listen;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@PropertySource("classpath:xu.properties")
public class FileListener extends FileAlterationListenerAdaptor {

    private ListenerService listenerService;

    public FileListener(ListenerService listenerService) {
        this.listenerService = listenerService;
    }
    public static final String KEY="dict";
//    @Autowired
//    XuProperties properties;
//    String key = "dict";

    @Override
    public void onFileCreate(File file) {
        log.info("FileListener 监听到文件新建,名称: {} 路径:{}", file.getName(), file.getAbsolutePath());
        try {
            listenerService.writeJsonFileToMemory(KEY, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFileChange(File file) {
        log.info("FileListener 监听到文件改变,名称: {} 路径:{}", file.getName(), file.getAbsolutePath());
        try {
            listenerService.writeJsonFileToMemory(KEY, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFileDelete(File file) {
        log.info("FileListener 监听到文件删除,名称: {} 路径:{}", file.getName(), file.getAbsolutePath());
        listenerService.clear(KEY);

        File folder = new File(file.getParent());
        String[] list = folder.list();


        if (list != null && list.length > 0) {
            Arrays.stream(list).filter((x) -> x.endsWith(".json")).forEach((y) -> {
                try {
                    listenerService.writeJsonFileToMemory(KEY, new File(file.getParent() + "\\"+y));
                    log.info("虽然被删除,但是同目录下我找到了这个:{}", y);

                } catch (IOException e) {
                    log.error("读文件错误, name: {}", y);
                }
            });

        }
    }


    @Override
    public void onStart(FileAlterationObserver observer) {
        log.info("FileListener 启动完毕,监听路径: {}", observer.getDirectory().getAbsolutePath());

    }
//
//    @Override
//    public void onDirectoryCreate(File directory) {
//        log.info("FileListener 监听到文件夹创建,名称: {}", directory.getName());
//
//    }
//
//    @Override
//    public void onDirectoryChange(File directory) {
//        log.info("FileListener 监听到文件夹修改,名称: {}", directory.getName());
//
//    }
//
//    @Override
//    public void onDirectoryDelete(File directory) {
//        log.info("FileListener 监听到文件夹删除,名称: {}", directory.getName());
//
//    }


}
