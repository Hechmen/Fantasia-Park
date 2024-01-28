package cwk3;

 

  
/**
 * A bridge provides a one-way connection between two areas. It
 has a bridge code and information about both the source and
 the destination area
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bridge
{
    private String code;
    private Area fromArea;
    private Area toArea;
    
    public Bridge(String code, Area fromArea, Area toArea){
        this.code = code;
        this.fromArea = fromArea;
        this.toArea = toArea;
    }
    
    public String getCode(){
        return code;
    }
    
    public boolean canCross(Card card){
        return !toArea.isFull() && card.getLuxuryRating() >= 
               toArea.getLuxuryRating() && card.isEnoughCredits() 
               && fromArea.containsCard(card);
    }
    
    public String processCardMovement(Card card){
        // if (canCross(card)) {
            // fromArea.leave(card);
            // toArea.enter(card);
            // card.crossBridge();
            // return "Card successfully moved to " +toArea.getName();
        // } else {
            // return "Card cannot cross the bridge due to restrictions.";
        // }
        
        if(!canCross(card)) {
            return "fail";
        }
        
        fromArea.leave(card);
        toArea.enter(card);
        card.crossBridge();
        
        String out = "success";
        return out;
    }
    
    public String toString(){
        String info = "Bridge Code: " + code + "\nFrom Area: " 
                       + fromArea.getName() + " (Area Number: " 
                       + fromArea.getReferenceNumber() + ")" +
                       "\nTo Area: " + toArea.getName() + 
                       " (Area Number: " + toArea.getReferenceNumber() 
                       + ")\n";
        return info;
    }
}
