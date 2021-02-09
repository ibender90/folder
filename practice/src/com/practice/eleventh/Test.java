package com.practice.eleventh;

public class Test {
    public static void main(String[] args) {
        Warehouse ladu = new Warehouse();
        Picker artjom = new Picker(ladu);
        Courier oleg = new Courier(ladu);

        System.out.println(ladu);
        System.out.println(artjom);
        System.out.println(oleg);
        do {
            artjom.doWork();
            oleg.doWork();
            artjom.bonus();
            oleg.bonus();
        } while (ladu.getCountOrder() < 1501);

        System.out.println(ladu);
        System.out.println(artjom);
        System.out.println(oleg);

    }
}
