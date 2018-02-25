package blackjack.model.card;

public class Card {

    private CardSuit suit;
    private CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public int score() {
      return value.getCardValue();
    }

    public String toString(){
        return suit.name() + value.getCardSymbol();
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}
