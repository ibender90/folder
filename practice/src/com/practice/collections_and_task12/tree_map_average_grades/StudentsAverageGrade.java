package com.practice.collections_and_task12.tree_map_average_grades;

import java.io.Serializable;

public class StudentsAverageGrade implements Comparable<StudentsAverageGrade>, Serializable { //класс для сортировки объектов по полю оценка
    private final String name;
    private final float averageGrade;

    public StudentsAverageGrade(String name, float averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public float getAverageGrade() {
        return averageGrade;
    }


    @Override
    public int compareTo(StudentsAverageGrade thatGrade) {
        if(this.averageGrade < thatGrade.getAverageGrade()){
            return -1;
        }
        if(this.averageGrade > thatGrade.getAverageGrade()){
            return 1;
        }
        else return name.compareTo(thatGrade.getName());
    }

    @Override
    public String toString() {
        return name +" has average grade: " + averageGrade;
    }
}
