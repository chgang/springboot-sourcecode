package com.qskx.run;

import com.qskx.aop.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Resource
    private Student student;

    @Test
    public void test() {
        student.add("");

        student.delete();
    }
}
