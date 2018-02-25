package blackjack.model.card;

public enum CardValue {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 11);

    private int value;
    private String symbol;

    CardValue(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public static CardValue fromString(String symbol){
        for (CardValue value : values()){
            if(value.getCardSymbol().equals(symbol)){
                return value;
            }
        }
        throw new IllegalArgumentException("Symbol: "+ symbol + " not found in legal card values");
    }

    public int getCardValue() {
        return value;
    }

    public String getCardSymbol() {
        return symbol;
    }

}