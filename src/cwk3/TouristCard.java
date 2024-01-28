package cwk3;


/**
 * Write a description of class TouristCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TouristCard extends Card
{
    private String nameOfTourOperator;
    private int tourOperatorId;
    
    public TouristCard(int cardId, String guestName, int luxuryRating, int credits, String nameOfTourOperator, int tourOperatorId){
        super(cardId, guestName, luxuryRating, credits);
        this.nameOfTourOperator = nameOfTourOperator;
        this.tourOperatorId = tourOperatorId;
    }
    
    //Getters and Setters
    public String getNameOfTourOperator(){
        return nameOfTourOperator;
    }
    
    public void setNameOfTourOperator(String nameOfTourOperator){
        this.nameOfTourOperator = nameOfTourOperator;
    }
    
    public int getTourOperatorId(){
        return tourOperatorId;
    }
    
    public void setTourOperatorId(int tourOperatorId){
        this.tourOperatorId = tourOperatorId;
    }
    
    public String toString(){
        String info = super.toString() + "\nTour Operator: " 
        + nameOfTourOperator + "\nOperator ID: " + tourOperatorId;
        return info;
    }
}
