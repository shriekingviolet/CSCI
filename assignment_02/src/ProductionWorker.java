
public class ProductionWorker extends Employee {
    
    private int shift;
    private double payRate;
    
    public ProductionWorker(String fn, String ln, String eid, String hd, int s, double pr){
    
        super(fn, ln, eid, hd);
        
        shift = s;
        payRate = pr;
    }
    
    //setters
    public void setShift(int s){
        shift = s;
    }
    
    public void setPayRate(double pr){
        payRate = pr;
    }
    
    
    //getters
    public int getShift(){
    
        return shift;
    }
    
    public double getPayRate(){
    
        return payRate;
    }
}
