import blackjack.Deck;
import blackjack.Game;
import blackjack.model.card.Card;
import blackjack.model.card.CardSuit;
import blackjack.model.card.CardValue;
import blackjack.model.players.Dealer;
import blackjack.model.players.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String [] args) {
        Deck deck = new Deck();
        if(args.length == 1) {
            try {
                deck = new Deck(getCardsFromFile(args[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Player player = new Player();
        Dealer dealer = new Dealer();

        Game game = new Game(player, dealer, deck);
        game.play();
        game.printResults();
    }


    private static List<Card> getCardsFromFile(String filePath) throws IOException {
        String cardLine = new String(Files.readAllBytes(Paths.get(filePath)));

        String [] cardStrings = cardLine.split(", ");
        return Stream.of(cardStrings).map(cardString -> {
            CardSuit cardSuit = CardSuit.fromString(String.valueOf(cardString.charAt(0)));
            CardValue cardValue = CardValue.fromString(String.valueOf(cardString.charAt(1)));
            return new Card(cardSuit, cardValue);
        }).collect(Collectors.toList());
    }
}
