package com.practice.collections_and_task12.compare;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> { // реализуем интерфейс comparable, параметризируем нашим классом, переопределяем метод compareTo

    private final Suit suit;
    private final Face face;

    public enum Suit {SPADES('S'), HEARTS('H'), CLUBS('C'), DIAMONDS('D');
        public char shortName;
        Suit(char shortName){
            this.shortName = shortName;
        }
    }

    public enum Face { DEUCE('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'),
        NINE('9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');
        public char shortName;
        Face(char shortName){
            this.shortName = shortName;
        }}

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
