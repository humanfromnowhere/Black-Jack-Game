
import java.util.*;

public class Deck
{

    public static final int heart = 0; //♥
    public static final int diamond= 1;//♦
    public static final int spade= 2;//♠
    public static final int club= 3;//♣
  
    public static  int jack = 11;
    public static  int queen = 12;
    public static  int king = 13;
    public static  int ace = 14;
    
    private ArrayList<Card> deck;
   
    public Deck()
    {
        deck = new ArrayList<Card>();
        
        for(int rank = 2; rank <= ace; rank++)
        {
            for(int suit = heart; suit <= club; suit++)
            {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
    }
    
    
    public ArrayList<Card> getCards()
    {
        return deck;
    }
    
   
    public Card deal()
    {
        return deck.remove(0);
    }
    
   
    public void print()
    {
        for(Card c: deck)
        {
            System.out.println(c);
        }
    }
    public void shuffle()
    {
        for(int i = 0; i < deck.size(); i++)
        {
            int randomIndex = Randomizer.nextInt(52);
            Card x = deck.get(i);
            Card y = deck.get(randomIndex);
            
            deck.set(i, y);
            deck.set(randomIndex, x);
        }
    }

}

