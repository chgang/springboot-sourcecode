package com.qskx.run;

import com.qskx.aop.Student;
import com.qskx.aop.Teacher;
import com.qskx.feign.CarClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Resource
    private Student student;

    @Autowired
    private Teacher teacher;

    @Test
    public void test() {
        student.add("");
//        student.delete();

//        teacher.work();
    }

    @Autowired
    private CarClient carClient;

    @Test
    public void feign() {
//        carClient.getCarNo();
        System.out.println("test");
    }

    public void bigCollection() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student());
        studentList.add(new Student());
        studentList.remove(0);
    }

}
