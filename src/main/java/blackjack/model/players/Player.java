package blackjack.model.players;

public class Player extends AbstractPlayer {
    private static final int STOP_DRAWING = 17;

    public Player(){
        super("Sam");
        hand = new Hand();
        setScoreToBeat(STOP_DRAWING);
    }

    @Override
    public boolean shouldHit() {
        return hand.score() < scoreToBeat;
    }
}
