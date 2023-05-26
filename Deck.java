import java.util.*;

public class Deck
{
    private Stack<Card> deck;

    public Deck(Stack<Card> deck)
    {
        this.deck = deck;
    }

    //deck of cards constructor
    public Deck(boolean makeDeck)
    {
        deck = new Stack<Card>();
        if(makeDeck) {
            for (Suit cardSuit : Suit.values()) {
                for (Rank cardValue : Rank.values()) {
                    deck.add(new Card(cardSuit, cardValue));
                }
            }
        }
    }

    public void displayDeck()
    {
        System.out.println(Arrays.asList(deck));
    }

    //function to shuffle and display deck for testing
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    //deals and removes card from deck
    public Card dealCard()
    {
        return deck.pop();
    }

    public Card getCard(int i)
    {
        return this.deck.get(i);
    }

    //checks if deck has cards
    public boolean hasCards()
    {
        if(deck.size()>0)
        {
            return true;
        } else {
            return false;
        }
    }

    public void emptyDeck()
    {
        deck.clear();
    }

    //creates a new stack of cards to be added to the deck
    public void addCards(Stack<Card> moveTo)
    {
        int thisDeckSize = this.deck.size();

        //move cards to into new deck
        for(int i = 0; i < thisDeckSize; i++)
        {
            moveTo.add(this.getCard(i));
        }
    }

    //reloads the main deck from discarded deck
    public void reloadDeck(Deck discard)  {
        discard.addCards(deck);
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Deck empty, creating new deck from discard pile and shuffling.");
    }

    //allows check of deck size
    public int cardsLeft()
    {
        return deck.size();
    }
}
