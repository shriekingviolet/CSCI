
public class ShiftSupervisor extends Employee{
    
    private int shift;
    private double salary;
    private double bonusRate;
    
    public ShiftSupervisor(String fn, String ln, String eid, String hd, int s, double sal, double br){
    
        super(fn, ln, eid, hd);
        
        shift = s;
        salary = sal;
        bonusRate = br;
    }
    
    //setters
    public void setShift(int s){
        shift = s;
    }
    
    public void setSalary(int s){
        salary = s;
    }
    
    public void setBonusRate(int br){
        bonusRate = br;
    }
    
    //getters
    public int getShift(){
    
        return shift;
    }
    
    public double getSalary(){
    
        return salary;
    }
    
    public double getBonusRate(){
    
        return bonusRate;
    }
    
}
