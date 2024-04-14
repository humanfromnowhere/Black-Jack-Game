
import java.util.*;

public class BlackJack {


    public static final int heart = 0; //♥
    public static final int diamond= 1;//♦
    public static final int spade= 2;//♠
    public static final int club= 3;//♣
  
    public static  int jack = 11;
    public static  int queen = 12;
    public static  int king = 13;
    public static  int ace = 14;
    
    Scanner sc = new Scanner(System.in);
   
    private String getPlayerMove() {
        while (true) {
            System.out.println("Enter move (hit/stand): ");
            String move = sc.nextLine();
            
            if (move.equals("hit") || move.equals("stand")) {
                return move;
            }
            
            System.out.println("Please try again."); 
        }
    }
  
    private void dealerTurn(Hand dealer, Deck deck) {
        while (true) {
            System.out.println("Dealer's hand");
            System.out.println(dealer);
            
            int value = dealer.getValue();
            System.out.println("Dealer's hand has value " + value);
            
            
            
            if (value < 17) {
                System.out.println("Dealer hits");
                Card c = deck.deal();
                dealer.addCard(c);
                
                System.out.println("Dealer card was " + c);
                
                if (dealer.bust()) {
                    System.out.println("Dealer busted!");
                    break;
                }
            } else {
                System.out.println("Dealer stands.");
                break;
            }
        }
    }
   
    private boolean playerTurn(Hand player, Deck deck) {
        while (true) {
            String move = getPlayerMove();
            
            if (move.equals("hit")) {
                Card c = deck.deal();
                System.out.println("Your card was: " + c);
                player.addCard(c);
                System.out.println("Player's hand");
                System.out.println(player);
                
                if (player.bust()) {
                    return true;
                }
            } else {
               
                return false;
            }
        }
    }
   
    private boolean playerWins(Hand player, Hand dealer) {
        if (player.bust()) {
            return false;
        }
        
        if (dealer.bust()) {
            return true;
        }
        
        return player.getValue() > dealer.getValue();
    }
   
    private boolean push(Hand player, Hand dealer) {
        return player.getValue() == dealer.getValue();
    }
    
    private double findWinner(Hand dealer, Hand player) {
        if (playerWins(player, dealer)) {
            System.out.println("Player wins!");
            
            if (player.blackjack()) {
                return 1.5;
            }
            
            return 1;
        } else if (push(player, dealer)) {
            System.out.println("You push");
            return 0;
        } else {
            System.out.println("Dealer wins");
            return -1;
        }
    }
    private boolean playRound() {
        Deck deck = new Deck();
        deck.shuffle();
        
        Hand player = new Hand();
        Hand dealer = new Hand();
        
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        
        System.out.println("Player's Hand");
        System.out.println(player);
        
        System.out.println("Dealer's hand");
        dealer.showDealerHand();
        
        boolean playerBusted = playerTurn(player, deck);
        
        if (playerBusted) {
            System.out.println("You busted :(");
        }
        dealerTurn(dealer, deck);
        double result = findWinner(dealer, player);
        System.out.println("Enter 'Y' to play again, or any other key to quit.");
        String toPlay = sc.nextLine();
        return toPlay.equalsIgnoreCase("Y");
       }
        public void run() {
        System.out.println("Welcome to Blackjack 😁🤩");

        while (true) {
            boolean play = playRound();
            
            if (!play) {
                break;
            }
        }  
        System.out.println("Thanks for playing 😊😆");
    }
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.run();
    }
}
