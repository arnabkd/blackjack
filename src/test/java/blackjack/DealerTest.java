package blackjack;

import blackjack.model.card.Card;
import blackjack.model.card.CardSuit;
import blackjack.model.card.CardValue;
import blackjack.model.players.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DealerTest {

    Dealer dealer;

    @BeforeEach
    public void setUp(){
        dealer = new Dealer();
    }


    @Test
    public void testBlackjack() {
        dealer.addCard(new Card(CardSuit.C, CardValue.ACE));
        dealer.addCard(new Card(CardSuit.C, CardValue.TEN));

        assertTrue(dealer.hasBlackjack(), "dealer should have blackjack");
    }

    @Test
    public void testIsBust() {
        dealer.addCard(new Card(CardSuit.C, CardValue.ACE));
        dealer.addCard(new Card(CardSuit.H, CardValue.ACE));

        assertTrue(dealer.isBust(), "dealer should bust when getting two aces");
    }

    @Test
    public void testDealerShouldNotHit(){
        dealer.addCard(new Card(CardSuit.C, CardValue.TEN));
        dealer.addCard(new Card(CardSuit.C, CardValue.NINE));
        dealer.setScoreToBeat(18);

        assertFalse(dealer.shouldHit());
    }

    @Test
    public void testDealerShouldHit(){
        dealer.addCard(new Card(CardSuit.C, CardValue.TEN));
        dealer.addCard(new Card(CardSuit.C, CardValue.SIX));
        dealer.setScoreToBeat(18);

        assertTrue(dealer.shouldHit());
    }

    @Test
    public void testDealerShouldStopWantingToHit(){
        dealer.addCard(new Card(CardSuit.C, CardValue.TEN));
        dealer.addCard(new Card(CardSuit.C, CardValue.SEVEN));
        dealer.setScoreToBeat(18);

        assertTrue(dealer.shouldHit());

        dealer.addCard(new Card(CardSuit.C, CardValue.THREE));

        assertFalse(dealer.shouldHit());
    }
}

