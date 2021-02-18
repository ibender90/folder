package com.practice.collections_and_task12.tree_map_average_grades;

import java.io.Serializable;
import java.util.Objects;

public class SubjectGrade implements Serializable { // класс для создания мап предмет-оценка
    private final String subjectName;
    private final int grade;

    public SubjectGrade(String subjectName, int grade) {
        this.subjectName = subjectName;
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) { // при создании hashSet необходимы эти методы в классе
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectGrade that = (SubjectGrade) o;
        return grade == that.grade && Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName, grade);
    }

    @Override
    public String toString() {
        return subjectName + "- grade: " + grade ;
    }
}
