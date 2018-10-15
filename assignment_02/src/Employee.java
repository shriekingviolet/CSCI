
public class Employee {
    
    private String firstName;
    private String lastName;
    private String employeeID;
    private String hireDate;
    
    public Employee(String fn, String ln, String eid, String hd){
    
        firstName = fn;
        lastName = ln;
        employeeID = eid;
        hireDate = hd;
    }
    
    public boolean isSameFirstName(String n){
    
        return firstName.equals(n);
    }
    
    public boolean isSameLastName(String n){
    
        return lastName.equals(n);
    }
    
    //setters
    public void setFirstName(String fn){
        firstName = fn;
    }
    
    public void setLastName(String ln){
        lastName = ln;
    }
    
    public void setEmployeeID(String eid){
        employeeID = eid;
    }
    
    public void setHireDate(String hd){
        hireDate = hd;
    }
    
    //getters
    public String getFirstName(){
    
        return firstName;
    }
    
    public String getLastName(){
    
        return lastName;
    }
    
    public String getemployeeID(){
    
        return employeeID;
    }
    
    public String getHireDate(){
    
        return hireDate;
    }
    
}
