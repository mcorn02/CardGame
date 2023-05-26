import java.util.Scanner;

/*
    CS282-1913 – Spring 2023
    Card Game Create Deck Object
    Michael Corn
    5/3/23

    So far, this card game program has a deck object which holds Cards,
    Cards each have a suit and a value,
    there is a printlist method, shuffle method, and a deal a card method
*/

public class CardGame
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Michael's BlackJack Table!\n");
        System.out.println("Menu:");

        int choice = 0;

        while(choice != 50)
        {
            choice = menu();
            switch(choice)
            {
                case 1:
                    System.out.println("Game starting!");
                    System.out.println();//blank line
                    Game Blackjack = new Game();
                    break;
                case 2:
                    System.out.println("Rules of Blackjack:");
                    break;
                case 3:

                    break;
                case 4:
            }
        }
    }

    public static int menu()
    {
        int choice;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter 1 to play a round\n" +
                "Enter 2 to display the game rules\n" +
                "Enter 3 to run Test Mode");
        System.out.print("Enter choice: ");
        try
        {
            choice = in.nextInt();
            while(choice < 1 || choice >5)
            {
                System.out.println("Please enter a valid menu choice: ");

                choice = in.nextInt();
            }
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("!!Non Integer entered!!");
            in.next();
            choice=99;
        }

        System.out.println(); //prints blank line
        return choice;
    }
}