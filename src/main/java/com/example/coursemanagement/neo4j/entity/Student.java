package com.example.coursemanagement.neo4j.entity;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Arrays;

@NodeEntity
public class Student {
    @Id
    private String studentNo;
    private String name;
    private String sex;
    @Relationship(type = "SelectCourse")
    private SelectCourse[] selectCourses;

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", selectCourses=" + Arrays.toString(selectCourses) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (!getStudentNo().equals(student.getStudentNo())) return false;
        if (!getName().equals(student.getName())) return false;
        if (!getSex().equals(student.getSex())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getSelectCourses(), student.getSelectCourses());
    }

    @Override
    public int hashCode() {
        int result = getStudentNo().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSex().hashCode();
        result = 31 * result + Arrays.hashCode(getSelectCourses());
        return result;
    }

    public SelectCourse[] getSelectCourses() {

        return selectCourses;
    }

    public void setSelectCourses(SelectCourse[] selectCourses) {
        this.selectCourses = selectCourses;
    }

    public String getStudentNo() {

        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
