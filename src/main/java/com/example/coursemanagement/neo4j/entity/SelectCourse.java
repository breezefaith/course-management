package com.example.coursemanagement.neo4j.entity;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="SELECT_COURSE")
public class SelectCourse {
    @Id
    private Student student;
    @Id
    private Course course;
    private int grade;

    @Override
    public String toString() {
        return "SelectCourse{" +
                "student=" + student +
                ", course=" + course +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SelectCourse)) return false;

        SelectCourse that = (SelectCourse) o;

        if (getGrade() != that.getGrade()) return false;
        if (!getStudent().equals(that.getStudent())) return false;
        return getCourse().equals(that.getCourse());
    }

    @Override
    public int hashCode() {
        int result = getStudent().hashCode();
        result = 31 * result + getCourse().hashCode();
        result = 31 * result + getGrade();
        return result;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
