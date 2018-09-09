package com.example.coursemanagement.neo4j.entity;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Arrays;

@NodeEntity
public class Course {
    @Id
    private String courseNo;
    private String name;
    @Relationship(type = "SelectCourse")
    private SelectCourse[] selectCourses;

    @Override
    public String toString() {
        return "Course{" +
                "courseNo='" + courseNo + '\'' +
                ", name='" + name + '\'' +
                ", selectCourses=" + Arrays.toString(selectCourses) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (!getCourseNo().equals(course.getCourseNo())) return false;
        if (!getName().equals(course.getName())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getSelectCourses(), course.getSelectCourses());
    }

    @Override
    public int hashCode() {
        int result = getCourseNo().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + Arrays.hashCode(getSelectCourses());
        return result;
    }

    public SelectCourse[] getSelectCourses() {

        return selectCourses;
    }

    public void setSelectCourses(SelectCourse[] selectCourses) {
        this.selectCourses = selectCourses;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
