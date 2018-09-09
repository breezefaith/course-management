package com.example.coursemanagement.neo4j.dao;

import com.example.coursemanagement.neo4j.entity.Course;
import com.example.coursemanagement.neo4j.entity.SelectCourse;
import com.example.coursemanagement.neo4j.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception{
        Student s1=new Student();
        s1.setStudentNo("s1");
        s1.setName("zzc");
        s1.setSex("男");

        Student s2=new Student();
        s2.setStudentNo("s2");
        s2.setName("szh");
        s2.setSex("女");

        Course c1=new Course();
        c1.setCourseNo("c1");
        c1.setName("高等数学");

        Course c2=new Course();
        c2.setName("C语言");
        c2.setCourseNo("c2");


        SelectCourse selectCourse1=new SelectCourse();
        selectCourse1.setStudent(s1);
        selectCourse1.setCourse(c1);
        selectCourse1.setGrade(100);

        SelectCourse selectCourse2=new SelectCourse();
        selectCourse2.setStudent(s1);
        selectCourse2.setCourse(c2);
        selectCourse2.setGrade(90);

        SelectCourse selectCourse3=new SelectCourse();
        selectCourse3.setStudent(s2);
        selectCourse3.setCourse(c1);
        selectCourse3.setGrade(100);

        SelectCourse selectCourse4=new SelectCourse();
        selectCourse4.setStudent(s2);
        selectCourse4.setCourse(c2);
        selectCourse4.setGrade(100);


        SelectCourse[] selectCourses1=new SelectCourse[]{selectCourse1,selectCourse2};
        SelectCourse[] selectCourses2=new SelectCourse[]{selectCourse3,selectCourse4};

        s1.setSelectCourses(selectCourses1);
        c1.setSelectCourses(selectCourses1);

        s2.setSelectCourses(selectCourses2);
        c2.setSelectCourses(selectCourses2);

        System.out.println(studentDao.save(s1));

    }

    @After
    public void tearDown() throws Exception {
    }

}