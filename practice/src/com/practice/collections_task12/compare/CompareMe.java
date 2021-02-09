package com.practice.collections_task12.compare;

import java.util.*;

public class CompareMe {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Black");
        colors.add("Grey");
        colors.add("Orange");
        System.out.println("Before sorting: " + colors);
        Collections.sort(colors); //string implements interface comparable строки сравниваются посимвольно, у каждого символа есть численное представление,
        // например Red Black "R" - "B", метод проверят массив символов, за длину масива берёт строку, которая короче (Red)
        System.out.println("After sorting: " + colors);

        List<Card> deck = new ArrayList<>();
        for (Card.Face face : Card.Face.values()) { //берём значения из enum и создаём элементы, которые добавляем сразу в колоду
            for (Card.Suit suit : Card.Suit.values())
                deck.add(new Card(suit, face));
        }

        Collections.sort(deck);
        Card myCard = new Card(Card.Suit.SPADES, Card.Face.QUEEN); // queen of spades
        int i = Collections.binarySearch(deck, myCard); //binary search работает только в отсортированном списке
        if (i >= 0)
            System.out.println("This card was found at position: " + i);
        else System.out.println(myCard + "is not here");

        List<Card> cardList = new ArrayList<>(deck); //кладём все элементы списка deck  в новый список cardList
        Collections.addAll(cardList, myCard,myCard); // добавляю ещё пару карт queen of spades
        int frequency = Collections.frequency(cardList, myCard); // чтобы работал этот метод нужно сгенерировать в классе Card методы equals и hashcode
        System.out.println("This deck now contains "+ frequency+" "+myCard);

       // System.out.println("Original deck \n");
      //  printDeck(deck);
        System.out.println("\n\n\n");

        Collections.shuffle(deck);
      //  System.out.println("shuffled deck \n");
       // printDeck(deck);

        //Collections.sort(deck); //сортируем согласно методу, который реализован и переопределён в классе card
        // можно вызвать .reverseorder для сортировки в обратном порядке
        // Collections.sort(deck, Comparator.reverseOrder());
        System.out.println("sorted deck \n");
       // printDeck(deck);


    }

    private static void printDeck(List<Card> deck) {
        for (int i = 0; i < deck.size(); i++) {
            System.out.printf("%-20s %s", deck.get(i), (i + 1) % 4 == 0 ? "\n" : "  ");
        }
    }

    public static class Card implements Comparable<Card> { // реализуем интерфейс comparable, параметризируем нашим классом, переопределяем метод compareTo

        private final Suit suit;
        private final Face face;

        private enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}

        private enum Face {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

        public Card(Suit suit, Face face) {
            this.suit = suit;
            this.face = face;
        }

        @Override
        public int compareTo(Card cardToCompare) {
            Face[] values = Face.values(); // берём значения в enum face и добавляем в массив values
            List<Face> faces = Arrays.asList(values); // из массива создаём коллекцию
            // у коллекции все элементы будут иметь индексы ACE = 0, DEUCE = 1 и тд
            if (faces.indexOf(this.face) < faces.indexOf(cardToCompare.getFace())) { //индекс обложки карты на котором вызван метод сравниваем с индесом переданной в метод
                return -1;
            } else if (faces.indexOf(this.face) > faces.indexOf(cardToCompare.getFace())) {
                return +1;
            } else if (faces.indexOf(this.face) == faces.indexOf(cardToCompare.getFace())) {
                return String.valueOf(suit).compareTo(String.valueOf(cardToCompare.getSuit()));
                //если сравниваем две дамы, то смотрим их масть и сравниваем в алфавитном порядке (тут)
            }
            return 0;
        }

        public Suit getSuit() {
            return suit;
        }

        public Face getFace() {
            return face;
        }

        @Override
        public String toString() {
            return face + " of " + suit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return suit == card.suit && face == card.face;
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, face);
        }
    }
}
