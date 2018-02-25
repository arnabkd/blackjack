package blackjack;

import blackjack.model.card.Card;
import blackjack.model.card.CardSuit;
import blackjack.model.card.CardValue;
import blackjack.model.players.Dealer;
import blackjack.model.players.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GameTest {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    private Game game;

    @BeforeEach
    public void setUp(){
        player = new Player();
        dealer = new Dealer();
        deck = Mockito.mock(Deck.class);
        game = new Game(player, dealer, deck);
    }

    @Test
    public void testPlayerWinsWithBlackJackOnInitialHand(){
        when(deck.hit())
                .thenReturn(new Card(CardSuit.C, CardValue.ACE))
                .thenReturn(new Card(CardSuit.H, CardValue.ACE))
                .thenReturn(new Card(CardSuit.D, CardValue.TEN))
                .thenReturn(new Card(CardSuit.S, CardValue.TEN));
        game.play();

        assertEquals(player, game.getWinner());
    }

    @Test
    public void testDealerWinsWhenBothBustOnInitialHand(){
        when(deck.hit())
                .thenReturn(new Card(CardSuit.C, CardValue.ACE))
                .thenReturn(new Card(CardSuit.H, CardValue.ACE))
                .thenReturn(new Card(CardSuit.D, CardValue.ACE))
                .thenReturn(new Card(CardSuit.S, CardValue.ACE));
        game.play();

        assertEquals(dealer, game.getWinner());
    }

    @Test
    public void testPlayerWinsWhenHittingBlackjack(){
        when(deck.hit())
                .thenReturn(new Card(CardSuit.C, CardValue.TEN))
                .thenReturn(new Card(CardSuit.D, CardValue.TEN))
                .thenReturn(new Card(CardSuit.C, CardValue.FOUR))
                .thenReturn(new Card(CardSuit.D, CardValue.FOUR))
                .thenReturn(new Card(CardSuit.C, CardValue.SEVEN));
        game.play();

        assertEquals(player, game.getWinner());
    }

    @Test
    public void testDealerWinsWhenPlayerBusts(){
        when(deck.hit())
                .thenReturn(new Card(CardSuit.C, CardValue.TEN))
                .thenReturn(new Card(CardSuit.D, CardValue.TEN))
                .thenReturn(new Card(CardSuit.C, CardValue.FOUR))
                .thenReturn(new Card(CardSuit.D, CardValue.FOUR))
                .thenReturn(new Card(CardSuit.C, CardValue.EIGHT));
        game.play();

        assertEquals(dealer, game.getWinner());
    }

    @Test
    public void testDealerWinsWhenSurpassingPlayerScore(){
        when(deck.hit())
                .thenReturn(new Card(CardSuit.D, CardValue.TEN))
                .thenReturn(new Card(CardSuit.C, CardValue.TEN))
                .thenReturn(new Card(CardSuit.D, CardValue.SEVEN))
                .thenReturn(new Card(CardSuit.C, CardValue.SEVEN))
                .thenReturn(new Card(CardSuit.D, CardValue.TWO));
        game.play();

        assertEquals(dealer, game.getWinner());
    }

    @Test
    public void testPlayerWinsWhenDealerBusts(){
        when(deck.hit())
                .thenReturn(new Card(CardSuit.D, CardValue.TEN))
                .thenReturn(new Card(CardSuit.C, CardValue.TEN))
                .thenReturn(new Card(CardSuit.D, CardValue.SEVEN))
                .thenReturn(new Card(CardSuit.C, CardValue.SEVEN))
                .thenReturn(new Card(CardSuit.D, CardValue.FIVE));
        game.play();

        assertEquals(player, game.getWinner());
    }
}
