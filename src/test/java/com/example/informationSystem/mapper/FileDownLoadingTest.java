package com.example.informationSystem.mapper;

import com.example.informationSystem.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/23 16:18
 */
@SpringBootTest
public class FileDownLoadingTest {

    @Autowired
    private FileUtils fileUpload;

    @Test
    public void testDownLoading(){

        Resource resource = fileUpload.loadFileAsResource("123.txt");

        System.out.println(resource);


    }

}
