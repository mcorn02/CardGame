public class Card
{
    private Suit suit;

    private Rank rank;

    //hand constructor
    public Card(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString()
    {
        return rank.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
    }

    public int getValue()
    {
        return rank.rankValue;
    }

    public Rank getRank()
    {
        return rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

}
