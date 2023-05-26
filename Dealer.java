public class Dealer extends Player
{
    //dealer constructor
    public Dealer()
    {
        super("Dealer");
    }

    public void printFirstHand()
    {
        System.out.println("Dealers hand: ");
        System.out.println(super.getHand().getCard());
        System.out.println("The other card is face down.");
        System.out.println();//blank line
    }


}

