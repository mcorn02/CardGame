import java.util.Scanner;

public class Player
{
    Scanner in = new Scanner(System.in);

    private String name;

    private Hand hand;

    //player constructor
    public Player(String name)
    {
        hand = new Hand();//makes new player hand
        this.name = name;
    }

    public Hand getHand()
    {
        return this.hand;
    }

    public void setHand(Hand hand)
    {
        this.hand = hand;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    //checks to see if player has blackjack
    public boolean hasBlackJack()
    {
        if(this.getHand().getHandValue() == 21)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public void printHand()
    {
        System.out.println(getName() + "'s hand: ");
        hand.displayHand();
        System.out.println("Hand value of: " + getHand().getHandValue());
        System.out.println();//blank line
    }

    public void decision(Deck deck, Deck discard)
    {
        int decision = 0;
        boolean getNumber = true;

        //validates input
        while (getNumber)
        {
            try{
                System.out.println("Press 1 to hit or 2 to stand");
                decision = in.nextInt();
                getNumber = false;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input");
                in.next();
            }
        }
        if(decision == 1)
        {
            this.hit(deck, discard);

            //exits if player has blackjack or busted
            if(this.getHand().getHandValue()>20)
            {
                return;
            } else
            {
                this.decision(deck, discard);
            }
        } else
        {
            //any other input is assumed to be a stand
            System.out.println("You chose to stand.");
            System.out.println(); //blank line
        }
    }

    public void hit(Deck deck, Deck discards)
    {
        if(!deck.hasCards())
        {
            deck.reloadDeck(discards);
        }
        this.hand.addCardFromDeck(deck);
        System.out.println(this.name + " is dealt a card");
        System.out.println();//blank line
        this.printHand();
    }
}
