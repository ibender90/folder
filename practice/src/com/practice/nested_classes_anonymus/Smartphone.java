package com.practice.nested_classes_anonymus;

public class Smartphone {
    private Display display;
    private SomeButton button;

    public interface SomeButton{ //интерфейсс
        void click();
    }

    public void initButton(){
        button = new SomeButton() { // анонимный класс создан из интерфейса
            @Override
            public void click() {
                System.out.println("щёлк");
            }
        };
    }
    public void turnOn(){
        initDisplay();
        initButton();
        button.click();
    }

    private void initDisplay(){
        display = new Display();
    }

    public Display getDisplay() {
        return display;
    }

}
