
import java.util.*;

public class Hand {

	public static final int heart = 0; //♥
    public static final int diamond= 1;//♦
    public static final int spade= 2;//♠
    public static final int club= 3;//♣
  
    public static  int jack = 11;
    public static  int queen = 12;
    public static  int king = 13;
    public static  int ace = 14;

   
    private ArrayList<Card> hand;
    
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    
    
    public void addCard(Card card)
    {
        hand.add(card);
    }
    
    public int getValue()
    {
        int res = 0;
        int aces = 0;
        
        for(Card card: hand)
        {
            res += card.getValue();
            
            if(card.getRank() == ace)
            {
                aces++;
            }
        }
        
        while(res > 21 && aces > 0)
        {
            res -= 10;
            aces--;
        }
        
        return res;
    }
    
    public boolean blackjack()
    {
        return getValue() == 21 && hand.size() == 2;
    }
    

    public boolean bust()
    {
        return getValue() > 21;
    }
    
  
    public void showDealerHand()
    {
        for(int x = 0; x < hand.size(); x++)
        {
            Card card = hand.get(x);
            
            if(x == 0)
            {
                System.out.print("X ");
            }
            else
            {
                System.out.print(card + " ");
            }
        }
        System.out.println();
    }
    
    
   
    public String toString()
    {
        String res = "";
        
        for(Card card: hand)
        {
            res += card + " ";
        }
        
        res += "(" + getValue() + ")";
        
        return res;
    }

}
