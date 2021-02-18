package com.practice.collections_and_task12.poker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    private final static Character[] a = new Character[]{'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    private final static Character[] b = new Character[]{'C', 'D', 'H', 'S'};
    private final static List<Character> cardValue = new ArrayList<>(Arrays.asList(a));
    private final static List<Character> cardSign = new ArrayList<>(Arrays.asList(a));

    private List<PokerCard> cardsInHand = new ArrayList<>(5);


    public List<PokerCard> fromString(String fiveCards) {
        List<PokerCard> temp = new ArrayList<>();
        String[] cardsArray = fiveCards.split(" ");
        for (String card : cardsArray) {
            char f = card.charAt(0);
            char s = card.charAt(1);
            PokerCard c = new PokerCard(f,s);
            temp.add(c);
        } return temp;
    }

    private class PokerCard {
        public char face; // число
        public char suit; // масть

        public PokerCard(char face, char suit) {
            this.face = face;
            this.suit = suit;
        }
    }
}