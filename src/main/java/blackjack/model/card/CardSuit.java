package blackjack.model.card;

public enum CardSuit {
    D, S, H, C;

    public static CardSuit fromString(String suitName) {
        return CardSuit.valueOf(suitName);
    }
}
