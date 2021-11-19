package ru.alishev.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );    //reads our application context


        //Music musicBean = context.getBean("musicBean", Music.class);
        //MusicPlayer player = new MusicPlayer(musicBean); //player gets bean that is created by spring framework

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MySpringConfig.class
        );

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        player.play(Genre.CLASSICAL);
        
        System.out.println("Player " + player.getPlayerName());
        System.out.println("Volume " + player.getVolume());

        PopMusic pop1 = context.getBean("popMusic", PopMusic.class);
        PopMusic pop2 = context.getBean("popMusic", PopMusic.class);

        System.out.println(pop1 == pop2); //two different beans were created using scope prototype

        context.close();
    }
}
