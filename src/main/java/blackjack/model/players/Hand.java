package blackjack.model.players;

import blackjack.model.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int score() {
        return cards.stream().mapToInt(Card::score).sum();
    }

    @Override
    public String toString(){
        return Stream.of(cards)
                .map(card -> card.toString())
                .collect(Collectors.joining(","));
    }
}
