package cwk3;

 

   
/**
 * A Card has an id number, name, a luxury rating, number of credits and points.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card 
{
    //Attributes
    private int cardId;
    private String guestName;
    private int luxuryRating;
    private int credits;
    private int points;
    
    //Constructor
    public Card(int cardId, String guestName, int luxuryRating, int credits){
        this.cardId = cardId;
        this.guestName = guestName;
        this.luxuryRating = luxuryRating;
        this.credits = credits;
        
        this.points = 0;
    }
    
    //Accessing attributes
    public int getCardID(){
        return cardId;
    }
    
    public String getGuestName() {
        return guestName;
    }
    
    public int getLuxuryRating(){
        return luxuryRating;
    }
    
    public int getPoints(){
        return points;
    }
    
    public int getCredits(){
        return credits;
    }
    
    public boolean isEnoughCredits(){
        return credits >= 4;
    }
    
    //Setter
    public void addCredits(int x){
        credits += x;
    }
    
    public void deductCredits(int x){
        credits -= x;
    }
    
    public void addPoints(int x){
        credits += x;
    }
    
    public void deductPoints(int x){
        credits -= x;
    }
    
    
    public void crossBridge(){
        if (isEnoughCredits()){
            deductCredits(4);
            addPoints(1);
        }
    }
    
    public void pointsToCredits(){
        int add = points/3;
        deductPoints(3*add);
        addCredits(add);
    }
    
    public String toString(){
        String info = "Card ID: "+cardId+ "\nGuest name: " 
                      +guestName+ "\nLuxury Rating: "+luxuryRating+ 
                      "\nCredits: " +credits+ "\nPoints: " +points + "\n";
        return info;
    }
}

