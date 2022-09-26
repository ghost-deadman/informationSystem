package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubjectMapperTest {
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    public void testPage(){
        Page<Subject> page = new Page<>(1, 3);
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","1号");
        subjectMapper.selectPage(page, queryWrapper);
        System.out.println("当前页数据:"+page.getRecords());
        System.out.println("总分页数量:"+page.getPages());
        System.out.println("总记录数量:"+page.getTotal());
        System.out.println("是否有下一页:"+page.hasNext());
        System.out.println("是否有上一页:"+page.hasPrevious());
    }

    @Test
    public void test(){
//        Scanner scanner = new Scanner(System.in);
//        do{
//            try{
//                int re = scanner.nextInt();
//                System.out.println(111);
//                break;
//            }catch(Exception e){
//                System.out.println(222);
//            }
//        }while(true);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date(System.currentTimeMillis());
        String dates = sdf.format(date);
        System.out.println(dates);

    }

    @Test
    public void testPageVo(){
        Page<Subject> page = new Page<>(1, 3);
        subjectMapper.selectPageVo(page, "1号");
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
