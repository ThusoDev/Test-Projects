import java.util.Scanner;


public class CoinTossGame {
     Scanner scanner;
    public static void main(String[] args)
    {
        CoinTossGame game = new CoinTossGame();
        game.scanner = new Scanner(System.in);

        Player player1 = new Player(game.requestPlayerName());
        player1.setGuess(game.Guess());

        Player player2 = new Player(game.requestPlayerName());
        if(player1.getGuess().equalsIgnoreCase(Coin.HEADS))
        {
            player2.setGuess(Coin.TAILS);
        }
        else
        {
            player2.setGuess(Coin.HEADS);
        }

        System.out.println("Flipping the coin...");
        Coin coin = new Coin();
        coin.flip();
        System.out.println("The coin landed on " + coin.getSide());

        game.Winner(player1, player2, coin);
        game.scanner.close();
    }
    public String requestPlayerName()
    {
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }

    void Winner(Player player1, Player player2, Coin coin)
    {
        String winner;
        if(coin.getSide().equalsIgnoreCase(player1.getGuess()))
        {
            winner = player1.getName();
        }
        else
        {
            winner = player2.getName();
        }

        System.out.println("The winner is " + winner);
    }

    public String Guess()
    {
        String prompt = String.format("%s or %s?", Coin.HEADS, Coin.TAILS);
        System.out.println(prompt);

        String guess = scanner.nextLine();

        while(!guess.equalsIgnoreCase(Coin.HEADS) && !guess.equalsIgnoreCase(Coin.TAILS))
        {
            System.out.println("Invalid guess. Try again. " + prompt);
            guess =  scanner.nextLine();
        }

        return guess;
    }
}