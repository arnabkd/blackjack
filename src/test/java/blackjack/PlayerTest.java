package blackjack;

import blackjack.model.card.Card;
import blackjack.model.card.CardSuit;
import blackjack.model.card.CardValue;
import blackjack.model.players.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testBlackjack() {
        player.addCard(new Card(CardSuit.C, CardValue.ACE));
        player.addCard(new Card(CardSuit.C, CardValue.TEN));

        assertTrue(player.hasBlackjack(), "player should have blackjack");
    }

    @Test
    public void testIsBust() {
        player.addCard(new Card(CardSuit.C, CardValue.ACE));
        player.addCard(new Card(CardSuit.H, CardValue.ACE));

        assertTrue(player.isBust(), "player should bust when getting two aces");
    }

    @Test
    public void testPlayerShouldNotHitOverSeventeen(){
        player.addCard(new Card(CardSuit.C, CardValue.TEN));
        player.addCard(new Card(CardSuit.C, CardValue.SEVEN));
        assertFalse(player.shouldHit());
    }

    @Test
    public void testPlayerShouldHitUnderSeventeen(){
        player.addCard(new Card(CardSuit.C, CardValue.TEN));
        player.addCard(new Card(CardSuit.C, CardValue.SIX));
        assertTrue(player.shouldHit());
    }

    @Test
    public void testPlayerShouldStopWantingToHit(){
        player.addCard(new Card(CardSuit.C, CardValue.TEN));
        player.addCard(new Card(CardSuit.C, CardValue.SIX));
        assertTrue(player.shouldHit());
        player.addCard(new Card(CardSuit.C, CardValue.THREE));
        assertFalse(player.shouldHit());
    }
}
