package blackjack;

import blackjack.model.card.Card;
import blackjack.model.card.CardSuit;
import blackjack.model.card.CardValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {

    Deck deck;
    List<CardSuit> cardSuits;
    List<CardValue> cardValues;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
        cardSuits = Arrays.asList(CardSuit.values());
        cardValues = Arrays.asList(CardValue.values());
    }


    @Test
    public void testNewDeckHasAllCards() {
        cardSuits.forEach(cardSuit ->
          cardValues.forEach(cardValue ->{
              Card card = deck.hit();
              assertTrue(cardSuits.contains(card.getSuit()));
              assertTrue(cardValues.contains(card.getValue()));
          }));
    }

    @Test
    public void testDeckGetsDepleted() {
        IntStream.rangeClosed(1,52).forEach(card -> {
            assertTrue(deck.hasCards(), "default deck has 52 cards");
            deck.hit();
        });
        assertFalse(deck.hasCards(), "deck is depleted after being hit 52 times");
    }
}
