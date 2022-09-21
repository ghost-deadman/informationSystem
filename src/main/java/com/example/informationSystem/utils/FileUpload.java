package com.example.informationSystem.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/16 14:25
 */
@Component
public class FileUpload {

    @Value("${file.path}")
    private String basePath;

    /**
     * 处理前端发来的文件
     * @param files 文件对象数组
     * @throws IOException 异常
     */
    public List<String> upload(List<MultipartFile> files) throws IOException {

        List<String> pathList = new ArrayList<>();

        String path;

        for (MultipartFile file : files){

            path = upload(file);

            pathList.add(path);

        }

        return pathList;

    }

    /**
     * 处理单个文件
     * @param file 文件对象
     * @throws IOException 异常
     */
    public String upload(MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();

        String path = new File("src/main/resources").getCanonicalPath();

        if(originalFilename != null){

            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            String fileName = UUID.randomUUID() + suffix;

            File dir = new File(path + "/" + basePath + "/" + fileName);

            if (!dir.exists()) {

                dir.mkdirs();

            }

            file.transferTo(dir);

            return dir.getPath();

        }

        return null;

    }



}
