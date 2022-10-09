package com.example.informationSystem.utils;

import com.alibaba.druid.util.StringUtils;
import com.example.informationSystem.entity.ProjectFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/16 14:25
 */
@Component
public class FileUtils {

    @Value("${file.path}")
    private String basePath;

    public ResponseEntity <byte []> testResponseEntity (ProjectFile projectFile, HttpSession session ) throws
            IOException {

        ServletContext servletContext = session.getServletContext();

        InputStream is = new FileInputStream(projectFile.getPath());

        byte[] bytes = new byte[is.available()];

        is.read(bytes);

        MultiValueMap<String,String> headers = new HttpHeaders();
        // 设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition","attachment;filename=" + projectFile.getName());
         // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK ;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,headers,statusCode);

        is . close ();
        return responseEntity ;

    }

    public Resource loadFileAsResource(String fileName) {

        try {

            Path filePath = Paths.get("src/main/resources/" + basePath + "/").toAbsolutePath().normalize();

            Path path = filePath.resolve(fileName).normalize();

            Resource resource = new UrlResource(path.toUri());

            if(resource.exists()) {

                return resource;

            } else {

                throw new RuntimeException("File not found " + fileName);

            }

        } catch (MalformedURLException ex) {

            throw new RuntimeException("File not found " + fileName, ex);

        }
    }

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

        String path = new File("src/main/resources").getCanonicalPath() + File.separator + basePath;

        if(originalFilename != null){

            //先创建路径
            File dir = new File(path);

            if (!dir.exists()) {

                dir.mkdirs();

            }

            //在创建文件
            File fileTrue = new File(path + File.separator + originalFilename);

            file.transferTo(fileTrue);

            return fileTrue.getPath();

        }

        return null;

    }



}
