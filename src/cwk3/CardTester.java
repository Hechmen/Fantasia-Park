package cwk3;

 

  
/**
 * Write a description of class CardTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardTester
{
    public static void main(String[] args)
    {
        // Creating Card objects
        Card card1 = new Card(1, "John Doe", 3, 10);
        Card card2 = new Card(2, "Jane Smith", 4, 15);

        // Displaying initial information
        System.out.println("Initial Card 1:\n" + card1);
        System.out.println("\nInitial Card 2:\n" + card2);

        // Testing methods
        card1.crossBridge();
        card2.crossBridge();

        System.out.println("\nAfter crossing the bridge:\n" + card1);
        System.out.println("\nAfter crossing the bridge:\n" + card2);

        card1.pointsToCredits();
        card2.pointsToCredits();

        System.out.println("\nAfter converting points to credits:\n" + card1);
        System.out.println("\nAfter converting points to credits:\n" + card2);

        // Adding and deducting credits
        card1.addCredits(5);
        card2.deductCredits(3);

        System.out.println("\nAfter adding and deducting credits:\n" + card1);
        System.out.println("\nAfter adding and deducting credits:\n" + card2);
    }
        
    
}
