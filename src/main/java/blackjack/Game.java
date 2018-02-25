package blackjack;

import blackjack.model.players.AbstractPlayer;
import blackjack.model.players.Dealer;
import blackjack.model.players.Player;

public class Game {

    private Player player;
    private Dealer dealer;
    private AbstractPlayer winner;

    private Deck deck;

    public Game(Player player, Dealer dealer, Deck deck) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    public void play() {
        dealInitialHands();
        if (!isGameOver()) {
            letPlayerDraw();
        }
        if (!isGameOver()){
            letDealerDraw();
        }
    }


    /**
     * Lets the dealer draw.
     * By design the dealer only stops drawing once they have surpassed the player's score.
     * In other words, once a dealer stops drawing, they will lose only if they go bust.
     */
    private void letDealerDraw() {
        dealer.setScoreToBeat(player.score());
        while (dealer.shouldHit()){
            dealer.addCard(deck.hit());
        }
        if(dealer.isBust()){
            setWinner(player);
        }else {
            setWinner(dealer);
        }
    }

    /**
     * Lets the player draw.
     */
    private void letPlayerDraw() {
        while (player.shouldHit()){
            player.addCard(deck.hit());
        }

        if(player.hasBlackjack()){
            setWinner(player);
        }else if(player.isBust()){
            setWinner(dealer);
        }
    }

    /**
     * Distribute two cards to each of the players.
     */
    public void dealInitialHands() {
        player.addCard(deck.hit());
        dealer.addCard(deck.hit());
        player.addCard(deck.hit());
        dealer.addCard(deck.hit());
        setInitialWinnerIfApplicable();
    }


    private void setInitialWinnerIfApplicable() {
        if (player.hasBlackjack() && dealer.hasBlackjack()){
            setWinner(player);
        }else if (player.isBust() && dealer.isBust()) {
            setWinner(dealer);
        }
    }

    private boolean isGameOver(){
        return getWinner() != null;
    }

    public AbstractPlayer getWinner() {
        return winner;
    }

    private void setWinner(AbstractPlayer winner) {
        this.winner = winner;
    }

    public void printResults(){
        if(isGameOver()){
            System.out.printf("%s\n%s\n%s\n" ,getWinner().getName(), player.toString(), dealer.toString());
        }
    }
}
