import java.util.Stack;

public class Hand
{

    private Stack<Card> hand;

    //hand constructor
    public Hand()
    {
        hand = new Stack<>();
    }

    //adds card to players hand
    public void addCardFromDeck(Deck deck)
    {
        hand.add(deck.dealCard());
    }

    public int getCardCount()
    {
        return hand.size();
    }

    //empties hand
    public void clear()
    {
        hand.clear();
    }


    public void displayHand()
    {
        for(int i = 0; i < hand.size(); i++)
        {
            System.out.println(hand.get(i));
        }
    }


    //gets hand value, decrements ace value to 1 if hand value is
    //greater than 21
    public int getHandValue()
    {
        int handValue = 0;
        int aceCounter = 0;

        //adds each card value to the hand value
        for(Card card: hand)
        {
            handValue += card.getValue();
        }

        //if we have multiple aces, go back and set each ace to 1
        //until hand value is less than 21
        if(handValue > 21 && aceCounter > 0)
        {
            while (aceCounter > 0 && handValue > 21)
            {
                aceCounter--;
                handValue -= 10;
            }
        }
        return handValue;
    }

    //method to view first card in hand
    public Card getCard()
    {
        return hand.peek();
    }

    //adds cards to discard deck at the end of the round
    //also clears the hand for the next round
    public void discardHandToDeck(Deck discards)
    {
        discards.addCards(hand);
        hand.clear();
    }
}
