package blackjack.model.players;

public class Dealer extends AbstractPlayer {

    public Dealer(){
        super("Dealer");
        hand = new Hand();
    }

    @Override
    public boolean shouldHit() {
        return hand.score() <= scoreToBeat;
    }
}
