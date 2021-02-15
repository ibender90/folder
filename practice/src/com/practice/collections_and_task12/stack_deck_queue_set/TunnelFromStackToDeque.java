package com.practice.collections_and_task12.stack_deck_queue_set;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class TunnelFromStackToDeque {
    public static void main(String[] args) {
        Stack<Vagon> trainGarage = new Stack<>();

        Vagon oil = new Vagon("Oil");
        trainGarage.push(new Vagon("Stone"));
        trainGarage.push(new Vagon("Wood"));
        trainGarage.push(new Vagon("People"));
        trainGarage.push(new Vagon("iPods"));
        trainGarage.push(oil);
        trainGarage.push(new Vagon("Birds"));
        trainGarage.push(new Vagon("Snow"));


        System.out.println("Last vagon entered to the tunnel was "+trainGarage.peek()); // .peek показывает последний элемет из стека

        System.out.println("Vagon with oil was found at position "+ trainGarage.search(oil));

//        while(!trainGarage.empty()){
//            System.out.println("What we have in the tunnel: "+trainGarage.pop());}  //. pop забирает из стека последний элемент

        Deque<Vagon> tunnel = new ArrayDeque<>();
        for(int i = 0; i < 7; i++){
            tunnel.add(trainGarage.pop()); // состав из вагонов выезжает из гаража и заезжает в тоннель
        }

        for (int i = 0; i < 7; i++){
            System.out.println(tunnel.pollLast());  //теперь можем отделять вагоны как с конца, так и с начала
        }

    }

    public static class Vagon {
        private static int vagonNumber = 1;
        private String vagonCargo;

        public Vagon(String vagonCargo) {
            this.vagonCargo = vagonCargo;
            vagonNumber++;
        }

        public static int getVagonNumber() {
            return vagonNumber;
        }

        public String getVagonCargo() {
            return vagonCargo;
        }

        @Override
        public String toString() {
            return "vagon with " +
                     vagonCargo;
        }
    }


}
