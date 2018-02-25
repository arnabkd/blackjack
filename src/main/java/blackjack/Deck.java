package blackjack;

import blackjack.model.card.Card;
import blackjack.model.card.CardSuit;
import blackjack.model.card.CardValue;

import java.util.Collections;
import java.util.Stack;
import java.util.Arrays;
import java.util.List;


public class Deck {
    private Stack<Card> cards;

    public Deck(List<Card> cards) {
        Collections.reverse(cards);
        this.cards = new Stack<>();
        this.cards.addAll(cards);
    }

    public Deck() {
        cards = new Stack<>();
        Arrays.stream(CardSuit.values()).forEach(suit ->
          Arrays.stream(CardValue.values()).forEach(value ->
                  cards.push(new Card(suit, value))));
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public Card hit() {
        return cards.pop();
    }

    public int size() {
        return cards.size();
    }

    public boolean hasCards() {
        return size() > 0;
    }
}
