package com.practice.get_set_class_as_parameter;

import java.util.Random;

public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void evaluate(Student a) {
        Random r = new Random();
        int grade = r.nextInt(4) + 2;
        String howGood = "";
        switch (grade){
            case 2:
                howGood = "плохо";
                break;
            case 3:
                howGood = "посредственно";
                break;
            case 4:
                howGood = "нормально";
                break;
            case 5:
                howGood = "хорошо";
                break;
        }
        System.out.println("Учиталь "+ this.name+" оценил "+ a.getName()+ " по предмету " +this.subject+ " на "+howGood);
    }
}


