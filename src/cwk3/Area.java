package cwk3;

import java.util.*;
/**
 * A Area is part of a ZAPP resort.Each area has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(cards) who can be on the  
 * area at any one time. Each area must maintain a list of all people (cards)
 * currently on the area. These lists are updated whenever cards enter or leave 
 * an area,so that it is always possible to say how many people (cards) are in the area 
 * and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Area 
{
  //Attributes
  private int referenceNumber;
  private String name;
  private int luxuryRating;
  private int capacity;
  private List<Card> cardsInArea;
  
  //Constructor
  public Area(int referenceNumber, String name, int luxuryRating, int capacity){
      this.referenceNumber = referenceNumber;
      this.name = name;
      this.luxuryRating = luxuryRating;
      this.capacity = capacity;
      this.cardsInArea = new ArrayList<>();
  }
  
  //Accessors
  public int getReferenceNumber(){
      return referenceNumber;
  }
  
  public String getName(){
      return name;
  }
  
  public int getLuxuryRating(){
      return luxuryRating;
  }
  
  public boolean isFull() {
        return cardsInArea.size() >= capacity;
  }
  
  public void enter(Card card) {
        if (!isFull()) {
            cardsInArea.add(card);
        }
  }
  
  public void leave(Card card){
      cardsInArea.remove(card);
  }
  
  public String listAllCards(){
      String cardsList = "";
      for (Card card : cardsInArea){
          cardsList += card.toString() + "\n";
      }
      return cardsList;
  }
  
  public String listAllCardsInArea() {
      String output = "";
      
      for(Card card : cardsInArea) {
          output += card.toString() + "\n";
      }
      
      return output;
  }
  
  public boolean containsCard(Card card){
      return cardsInArea.contains(card);
  }
  
  public String toString(){
      String info = "Reference Number: " +referenceNumber+ "\nName: " +name+ 
                    "\nLuxury Rating: " +luxuryRating+ "\nCapacity: " 
                    +capacity+ "\nList of cards: " +cardsInArea;
      return info;
  }
}
