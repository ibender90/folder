package com.practice.collections_and_task12.stack_deck_queue_set;

import com.practice.collections_and_task12.compare.Card;

import java.util.PriorityQueue;
import java.util.Queue;

public class SimpleQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(25);
        q.offer(18);
        q.offer(12);
        q.offer(50);

        System.out.println(q.poll()); //вытащить, удалить из очереди
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        Queue<Card> cardDeck = new PriorityQueue<>();
        //Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator()); если задать количество элементов и тот компаратор, кторый сортирует карты в обратном порядке,
        //то очередь будет заполняться в соответсвии с этим компаратором

        for (Card.Face face : Card.Face.values()) { //берём значения из enum и создаём элементы, которые добавляем сразу в колоду
            for (Card.Suit suit : Card.Suit.values())
                cardDeck.offer(new Card(suit, face)); // offer будет заполнять колоду в соответствии с compare to
        }

        for (int i = 0; i<10; i++){
            System.out.println(cardDeck.poll()); //даст сначала единицы, потом двойки, и тд
        }
        System.out.println(cardDeck.size()+ " cards remains in the deck");
        System.out.println(cardDeck.peek()); //показывает нам следующий элемент в очереди и кладёт его обратно
        System.out.println(cardDeck.peek());
        System.out.println(cardDeck.peek());
        System.out.println(cardDeck.size()+ " cards remains in the deck");


    }
}
