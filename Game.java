public class Game
{
    private Deck deck;
    private Deck discards;

    private Dealer dealer;
    private Player player;

    private int wins, losses, pushes;

    //game constructor
    public Game()
    {
        //score = 0 to start
        wins = 0;
        losses = 0;
        pushes = 0;

        //creates full deck of cards
        deck = new Deck(true);
        //creates empty deck for discards
        discards = new Deck(false);

        dealer = new Dealer();
        player = new Player("Player");

        deck.shuffle();
        stardRound();
    }

    //gameflow logic
    private void stardRound()
    {
        player.getHand().discardHandToDeck(deck);
        dealer.getHand().discardHandToDeck(deck);

        if(losses > 0 || wins > 0 || pushes > 0)
        {
            System.out.println();
            System.out.println("Next round starting, you have: " + wins + " win(s), " + losses +
                    " loss(es)" + " and " + pushes + " pushe(s)");

            //refills deck with discard pile if deck size is less than 5
            if(deck.cardsLeft() < 5)
            {
                deck.reloadDeck(discards);
            }
        }

        //deals two cards to dealer
        dealer.getHand().addCardFromDeck(deck);
        dealer.getHand().addCardFromDeck(deck);

        //deals two card to player
        player.getHand().addCardFromDeck(deck);
        player.getHand().addCardFromDeck(deck);

        //display both hands
        dealer.printFirstHand();
        player.printHand();

        if(dealer.hasBlackJack())
        {
            dealer.printHand();
            if(player.hasBlackJack())
            {
                //this results in a tie
                System.out.println("Dealer and player both have Blackjack, push!");
                pushes++;
                stardRound();
            }
            else {
                //dealer wins if just dealer has Blackjack
                System.out.println("Dealer has Blackjack, player loses");
                losses++;
                stardRound();
            }
        }

        //player wins if they have blackjack
        if(player.hasBlackJack())
        {
            System.out.println("You have Blackjack, you win!");
            wins++;
            stardRound();
        }

        player.decision(deck, discards);

        //check if player busted
        if(player.getHand().getHandValue() > 21)
        {
            System.out.println("You have busted!");

            //add a loss
            losses++;

            //start new round
            stardRound();
        }
        else if (player.getHand().getHandValue() == 21)
        {
            System.out.println("You have BlackJack! You win!");
            wins++;
            stardRound();
        }

        System.out.println("Dealer's turn");
        System.out.println();//blank line
        dealer.printHand();
        //dealer's turn
        //dealer hits whenever hand value is below 17
        while (dealer.getHand().getHandValue() < 17)
        {
            dealer.hit(deck, discards);
        }

        //check winner
        if(dealer.getHand().getHandValue() > 21)
        {
            System.out.println("Dealer busts, you win!");
            //add a win
            wins++;
        }
        else if (dealer.getHand().getHandValue() > player.getHand().getHandValue())
        {
            System.out.println("You lose!");
            losses++;
        }
        else if (player.getHand().getHandValue() > dealer.getHand().getHandValue())
        {
            System.out.println("You win!");
            wins++;
        }
        else
        {
            System.out.println("Push!");
        }
        stardRound();
    }
}
