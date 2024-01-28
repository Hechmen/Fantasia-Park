package cwk3;

import java.util.*;
/**
 * Write a description of class MyTester here.
 * 
 * @author 
 * @version 
 */
public class MyTester 
{   
    
    private void doTest()
    {
        ZAPP fantasia = new Park("Fantasia Pleasure Park");
        Scanner enter = new Scanner(System.in);
        // write your tests here
        System.out.println("Testing getCardDetails");
        int testCardId = 299; // Example card ID
        System.out.println("Card Details: " + fantasia.getCardDetails(testCardId));
        
        System.out.println("Testing toString");
        System.out.println(fantasia); // Assuming fantasia implements ZAPP
        
        System.out.println("Testing getCardLocation");
        System.out.println("Card Location: " + fantasia.getCardLocation(testCardId));
        
        System.out.println("Testing getAreaNumber");
        String testAreaName = "Lobby"; // Example area name
        System.out.println("Area Number: " + fantasia.getAreaNumber(testAreaName));
        
        System.out.println("Testing getAllCardsInAllAreas");
        System.out.println(fantasia.getAllCardsInAllAreas());

        System.out.println("Testing getAllCardsInOneArea");
        System.out.println("Cards in " + testAreaName + ": " + fantasia.getAllCardsInOneArea(testAreaName));
        
        System.out.println("Testing convertPoints");
        fantasia.convertPoints(testCardId);
        System.out.println("Post Conversion Card Details: " + fantasia.getCardDetails(testCardId));
        
        System.out.println("Testing topUpCredits");
        int creditsToAdd = 50; // Example credit amount
        fantasia.topUpCredits(testCardId, creditsToAdd);
        System.out.println("New Card Details: " + fantasia.getCardDetails(testCardId));
        
        System.out.println("Testing canMove");
        String testBridgeCode = "ABC1"; // Example bridge code
        System.out.println("Can move: " + fantasia.canMove(testCardId, testBridgeCode));

        System.out.println("Testing move");
        System.out.println(fantasia.move(testCardId, testBridgeCode));
        
     }
     
     
    
    public static void main(String[] args){
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
