
public class Card {

    public static final int heart = 0; //♥
    public static final int diamond= 1;//♦
    public static final int spade= 2;//♠
    public static final int club= 3;//♣
  
    public static  int jack = 11;
    public static  int queen = 12;
    public static  int king = 13;
    public static  int ace = 14;

    private int rank;
    private int suit;
    
   
    private String[] ranks = {"X", "X", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
   /*There are two Xs in front to provide padding so that integers receive their String representation at the appropriate index.
    * For instance, the String for 2 is located at index 2.
    */
    private String[] suits = {"♥", "♦", "♠", "♣"};
    public Card(int r, int s)
    {
        rank = r;
        suit = s;
    }
    public int getRank()
    {
        return rank;
    }
    public int getSuit()
    {
        return suit;
    }
    public int getValue()
    {
        int value = rank;
        if(rank > 10)
        {
            value = 10;
        }
        
        if(rank == ace)
        {
            value = 11;
        }
        return value;
    }
    public String rankToString(int r)
    {
        return ranks[r];
    }
    public String suitToString(int s)
    {
        return suits[s];
    }
    public String getSuitAsString()
    {
        return suitToString(suit);
    }
    public String getRankAsString()
    {
        return rankToString(rank);
    }
    public String toString()
    {
        String rankString = ranks[rank];
        String suitString = suits[suit];
        return rankString + suitString;
    }}
