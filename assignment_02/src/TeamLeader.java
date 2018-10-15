
public class TeamLeader extends ProductionWorker{
    
    private double bonusRate;
    private double trainingHours;
    private double hoursComplete;
    
    public TeamLeader(String fn, String ln, String eid, String hd, int s, double pr, double br, double th, double hc){
    
        super(fn, ln, eid, hd, s, pr);
        
        trainingHours = th;
        hoursComplete = hc;
    }
    
    //setters
    public void setBonusRate(double br){
        bonusRate = br;
    }
    
    public void setTrainingHours(double th){
        trainingHours = th;
    }
    
    public void setHoursComplete(double hc){
        hoursComplete = hc;
    }
    
    //getters
    public double getBonusRate(){
        return bonusRate;
    }
    
    public double getTrainingHours(){
        return trainingHours;
    }
    
    public double getHoursComplete(){
        return hoursComplete;
    }
}
