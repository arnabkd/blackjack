package blackjack.model.players;

import blackjack.model.card.Card;

public abstract class AbstractPlayer {
    private static final int BLACKJACK = 21;
    Hand hand;
    int scoreToBeat;

    String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    public abstract boolean shouldHit();

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public void setScoreToBeat(int scoreToBeat){
        this.scoreToBeat = scoreToBeat;
    }

    public boolean isBust(){
        return hand.score() > BLACKJACK;
    }

    public boolean hasBlackjack(){
        return hand.score() == BLACKJACK;
    }

    public int score() {
        return hand.score();
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, hand.toString());
    }

    public String getName() {
        return name;
    }
}
