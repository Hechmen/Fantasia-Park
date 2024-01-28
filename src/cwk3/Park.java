package cwk3;

 
import java.util.*;

/**This class implements the ZAPP interface
 *
 * @author 
 * @version 
 **/
public class Park implements ZAPP
{
    private String parkName;
    private List<Area> areas;
    private List<Bridge> bridges;
    private List<Card> cards;

    /** constructor
     */
    public Park(String nme) 
    {
        parkName = nme;
        areas = new ArrayList<>();
        bridges = new ArrayList<>();
        cards = new ArrayList<>();
        loadAreas();
        setUpBridges();
        loadCards();
        
        Area lobby = getArea("Lobby");
        for(Card card : cards){
            lobby.enter(card);
        }
    }
    
    /**
     * Returns all of the details of the park: its name and its areas 
     * including lists of cards in each area.
     */
    public String toString()
    {
        String result = "Park name: " + parkName + "\n";
        result += getAllCardsInAllAreas() + "\n";
        
        for (Bridge bridge : bridges){
            result += bridge.toString() + "\n";
        }
        return result;
    }
    
    /**Returns a String with details of a card
     * @param cardId - id number of the card
     * @return the details of the card as a String, or "No such card"
     */
    public String getCardDetails(int cardId)
    {
        for (Card card : cards){
            if (card.getCardID() == cardId){
                return card.toString();
            }
        }
        return "No such card";
    } 
    
    /**Returns the name of the area which contains the specified card or null
     * @param ccd - the specified card
     * @return the name of the Area which contains the card, or null
     **/
    public String getCardLocation(int cd)
    {
        Card card = getCard(cd);
        for (Area area : areas){
            if (area.containsCard(card)){
                return area.getName();
            }
        }
        return null;
    }
    
    /** Given the name of a area, returns the area id number
     * or -1 if area does not exist
     * @param name of area
     * @return id number of area
     */
    public int getAreaNumber(String ww)
    {
        if (getArea(ww) != null) {
            return getArea(ww).getReferenceNumber();
        }
        return -1;
    }
                
    /**Returns a String representation of all the cards on specified area
     * @param area is the name of the area 
     * @return a String representation of all cards on specified area
     **/
    public String getAllCardsInOneArea(String findAreaName)
    {

        for(Area area : areas){
            String areaName = area.getName();
            if(areaName.equals(findAreaName)){
                return area.listAllCards();
            }
        }
        
        return "Not found";
    }

    /**Returns a String representation of all the cards in all areas including the name of each area
     * @return a String representation of all cards on specified area
     **/
    public String getAllCardsInAllAreas()
    {
        for (Area area: areas){
            String stringArea = area.getName();
            return getAllCardsInOneArea(stringArea);
        }
        return "";
    }


    
    /**Returns true if a Card is allowed to move using the bridge, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination area
     * AND the destination area is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source area
     * AND the card id is for a card on the system
     * AND the bridge code is the code for a bridge on the system
     * @param trId is the id of the card requesting the move
     * @param brCode is the code of the bridge by which the card wants to move
     * @return true if the card is allowed on the bridge journey, false otherwise 
    **/
    public boolean canMove(int trId, String brCode)
    {   
            Card card = getCard(trId);
            Bridge bridge = getBridge(brCode);
            if (card == null || bridge == null){
                return false;
            }
            return bridge.canCross(card);
    }     

    /**Returns the result of a card requesting to move over a bridge.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination area
     * AND the destination area is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source area
     * AND the card id is for a card in the system
     * AND the bridge code is the code for a bridge on the system
     * If the bridge crossing can be made, the card information is removed from 
     * the source area, added to the destination area, card details updated and a suitable message returned.
     * a suitable message returned.
     * If bridge journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pCardId is the id of the card requesting the move
     * @param brCode is the code of the bridge by which the card wants to move
     * @return a String giving the result of the request 
     **/
    public String move(int pCardId, String brCode )
    {   //other checks optional
        Card card = getCard(pCardId);
        Bridge bridge = getBridge(brCode);
        if (card == null){
            return "Card not found in the system.";
        }
        if (bridge == null){
            return "Bridge not found in the system.";
        }
        if (bridge.canCross(card)){
            return bridge.processCardMovement(card);
        }
        
        return bridge.processCardMovement(card);
    }     

    /** Allows a card to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits purchased to be added to cards information
     */
    public void topUpCredits(int id, int creds)
    {
        Card card = getCard(id);
        if (card != null){
            card.addCredits(creds);
        }
    }
    
    /** Allows a card to convert points to credits
     *  @param cdId the id of the card toping up their credits
     */
    public void convertPoints(int cdId)
    {
        Card card = getCard(cdId);
        if (card != null){
            card.pointsToCredits();
        }
    }
    
    
   
    //***************private methods**************
    private void loadAreas()
    {
        areas.add(new Area(0, "Lobby", 0, 1000));
        areas.add(new Area(1, "Concourse", 1, 100));
        areas.add(new Area(2, "Waterworld", 3, 10));
        areas.add(new Area(3, "Wild West", 5, 2));
        areas.add(new Area(4, "Solitaire", 1, 1)); 
    }
        
    
    private void setUpBridges()
    {
        bridges.add(new Bridge("ABC1", getArea("Lobby"), getArea("Concourse")));
        bridges.add(new Bridge("BCD2", getArea("Lobby"), getArea("Concourse")));
        bridges.add(new Bridge("CDE3", getArea("Concourse"), getArea("Waterworld")));
        bridges.add(new Bridge("DEF4", getArea("Waterworld"), getArea("Concourse")));
        bridges.add(new Bridge("EFG5", getArea("Concourse"), getArea("Wild West")));
        bridges.add(new Bridge("FGH6", getArea("Wild West"), getArea("Solitaire")));
        bridges.add(new Bridge("GHJ6", getArea("Solitaire"), getArea("Wild West")));
        bridges.add(new Bridge("HJK7", getArea("Wild West"), getArea("Lobby")));
        bridges.add(new Bridge("JKL8", getArea("Waterworld"), getArea("Wild West")));
    }
    
    private void loadCards()
    {
        cards.add(new Card(1000, "Lynn", 5, 10));
        cards.add(new Card(1001, "May", 3, 20));
        cards.add(new Card(1002, "Nils", 10, 20));
        cards.add(new Card(1003, "Olek", 2, 12));
        cards.add(new Card(1004, "Pan", 3, 4));
        cards.add(new Card(1005, "Quin", 1, 5));
        cards.add(new Card(1006, "Raj", 10, 6));
        cards.add(new Card(1007, "Sol", 7, 20));
        cards.add(new Card(1008, "Tel", 6, 24));
        //TouristCard touristCard = new TouristCard(1009, "John", 4, 20, "ABC Tours", 12345);
    }
 
    /** Returns the card with the card id specified by the parameter
     * @return the card with the specified id
     **/
    private Card getCard(int id)
    {
        for (Card card : cards){
            if (card.getCardID() == id){
                return card;
            }
        }
        return null;
    }
    
    
    /** Returns the area with the name specified by the parameter
     * @return the area with the specified name
     **/
    private Area getArea(String areaName)
    {
        for (Area area : areas){
            if (area.getName().equals(areaName)){
                return area;
            }
        }
        return null;
    }
    
    /** Returns the area with the name specified by the parameter
     * @return the area with the specified name
     **/
    private Bridge getBridge(String br)
    {
        for(Bridge bridge : bridges){
            if (bridge.getCode().equals(br)){
                return bridge;
            }
        }
        return null;
    }
    
    
}
