//Violet Johnson & Hailey Hanson
//Assignment 2
//2018-10-05

//Facotry Employees
//This program reads factory worker data from a file, then allows the user to 
//search through the generated database of employees


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;



public class FactoryEmployees {
    
   
    private Employee[] employees;
    
    public FactoryEmployees()
    {
        String greeting = "This program allows the user access to several utilities\n "+
                "to manipulate and/or search through employee data.\n\n"+
                "You will first be asked to enter the name of the file\n"+
                "containing the factory data.\n\n"+
                "Then you will be given a menu of tasks which you may \n"+
                "repeat until you wish to Quit.";
        JOptionPane.showMessageDialog(null, greeting, "Factory Employee Utilites",1);              
        
        String dataFile = selectFileName("Select file containing factory employee information");
       
        loadEmployeesFromFile(dataFile);
        
        String firstMenu = "Now select the task you wish to perform";
        String answer = getUserInputFromMenu("");
        
        while (!answer.equals("Q"))
        {   
            processUserResponse(answer);
            answer = getUserInputFromMenu("");
        }
        System.exit(0);
    }
    
    public String toString()
    {
        String state = "employee Roll:\n";
        for(int dex =0;  dex< employees.length; dex++ )
        { 
            if(employees[dex] instanceof ProductionWorker)
            {
                ProductionWorker temp = (ProductionWorker)employees[dex];
                state += temp.toString();
            }
            else if(employees[dex] instanceof TeamLeader)
            {
                TeamLeader temp = (TeamLeader)employees[dex];
                state += temp.toString();
            }
            else if(employees[dex] instanceof ShiftSupervisor)
            {
                ShiftSupervisor temp = (ShiftSupervisor)employees[dex];
                state += temp.toString();
            }
        }
        return state;
    }
    
    
    private String searchOnFirstName(String n)
    {
        String results = "";
        
        for(int dex = 0; dex < employees.length; dex++)
        {
            Employee temp = employees[dex];
            n = n.trim();
            if(temp.isSameFirstName(n) )
            {
                results += temp.getFirstName()+" "+temp.getLastName()+"\n";  
            }
        }
        return results;        
    } 
    
    
    private String searchOnLastName(String n)
    {
        String results = "";
        for(int dex = 0; dex < employees.length; dex++)
        {
            Employee temp = employees[dex];
            n = n.trim();
            if(temp.isSameLastName(n) )
            {
                results += temp.getFirstName()+" "+temp.getLastName()+"\n";  
            }
        }
        return results;        
    }
    
    
    private String searchOnShift(int sh)
    {
        String results = "Star indicates shift supervisor:\n\n";
        for(int dex = 0; dex < employees.length; dex++)
        {
            Employee temp = employees[dex];
            if(temp instanceof ProductionWorker  )
            {
                ProductionWorker tempPW =(ProductionWorker)temp;
                if(tempPW.getShift() == sh)
                {
                    results += "   "+temp.getFirstName()+" "+temp.getLastName()+"\n";  
                }
            }
            if(temp instanceof ShiftSupervisor )
            {
                ShiftSupervisor tempPW =(ShiftSupervisor)temp;
                if(tempPW.getShift() == sh)
                {
                    results += "* "+temp.getFirstName()+" "+temp.getLastName()+"\n";  
                }
            }
        }
        return results;        
    }
    
    
    private String searchOnpostion(int pos)
    {
        String results = "";
        
        switch(pos)
        {
            case 1:
                results = searchForSuper();
                break;
            case 2:
                results = searchForTeamLeader();
                break;
            case 3:
                results = searchForProductionWorker();
                break;
                
        }
        return results;        
    }
    
    
    private String searchForSuper()
    {
        String results = "";
        for(int dex = 0; dex < employees.length; dex++)
        {
            Employee temp = employees[dex];
            if(temp instanceof ShiftSupervisor )
            {
                results += temp.getFirstName()+" "+temp.getLastName()+"\n";  
            }
        }
        return results;        
    }
    
    
    private String searchForTeamLeader()
    {
        String results = "";
        for(int dex = 0; dex < employees.length; dex++)
        {
            Employee temp = employees[dex];
            if(temp instanceof TeamLeader )
            {
                results += temp.getFirstName()+" "+temp.getLastName()+"\n";  
            }
        }
        return results;        
    }
    
    
    
    private String searchForProductionWorker()
    {
        String results = "";
        for(int dex = 0; dex < employees.length; dex++)
        {
            Employee temp = employees[dex];
            if(temp instanceof ProductionWorker )
            {
                results += temp.getFirstName()+" "+temp.getLastName()+"\n";  
            }
        }
        return results;        
    }
    
    
    
    private void loadEmployeesFromFile(String fileName)
    {
        
        String tempCode = "";
        String tempLine = "";
        
        String tempFirstName = "";
        String tempLastName = "";
        String tempDate = "";
        int tempShift = 0;
        double tempPay = 0.0;
        double tempBonus = 0.0;
        double tempTrainingHours = 0.0;
        double tempHoursComplete = 0.0;
        double tempSalary = 0.0;
        
        
        //opens file
        File inputFile = new File(fileName);
        
        //checks file connection
        if(!inputFile.exists()){
            
            JOptionPane.showMessageDialog(null, "Error opening input file", "File Error", 2);
        }
        
        //reads all lines of file to create employees object
        try{
            
            int index = 0;
        
            Scanner fileScanner = new Scanner(inputFile);
            
            while(fileScanner.hasNext()){
                
                fileScanner.nextLine();
                
                index++;
            }
            
            employees = new Employee[index];
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error opening input file", "File Error", 2);
            System.exit(0);
        }
        
        //loads in data from file
        try{
        
            int index = 0;
            
            Scanner fileScanner = new Scanner(inputFile).useDelimiter(",");
            
            while(fileScanner.hasNext()){
            
                tempCode = fileScanner.next();
                
                if(tempCode.charAt(0) == 'P'){
                
                    tempLine = fileScanner.nextLine();
                    Scanner stringScanner = new Scanner(tempLine).useDelimiter(",");
                    
                    tempFirstName = stringScanner.next();
                    tempLastName = stringScanner.next();
                    tempDate = stringScanner.next();
                    tempShift = stringScanner.nextInt();
                    tempPay = stringScanner.nextDouble();
                    
                    employees[index] = new ProductionWorker(tempFirstName, tempLastName, tempCode, tempDate, tempShift, tempPay);
                    
                    
                }
                else if(tempCode.charAt(0) == 'T'){
                
                    tempLine = fileScanner.nextLine();
                    Scanner stringScanner = new Scanner(tempLine).useDelimiter(",");
                    
                    tempFirstName = stringScanner.next();
                    tempLastName = stringScanner.next();
                    tempDate = stringScanner.next();
                    tempShift = stringScanner.nextInt();
                    tempPay = stringScanner.nextDouble();
                    tempBonus = stringScanner.nextDouble();
                    tempTrainingHours = stringScanner.nextDouble();
                    tempHoursComplete = stringScanner.nextDouble();
                    
                    employees[index] = new TeamLeader(tempFirstName, tempLastName, tempCode, tempDate, tempShift, tempPay, tempBonus, tempTrainingHours, tempHoursComplete);
                }
                else if(tempCode.charAt(0) == 'S'){
                
                    tempLine = fileScanner.nextLine();
                    Scanner stringScanner = new Scanner(tempLine).useDelimiter(",");
                    
                    tempFirstName = stringScanner.next();
                    tempLastName = stringScanner.next();
                    tempDate = stringScanner.next();
                    tempShift = stringScanner.nextInt();
                    tempSalary = stringScanner.nextDouble();
                    tempBonus = stringScanner.nextDouble();
                    
                    employees[index] = new ShiftSupervisor(tempFirstName, tempLastName, tempCode, tempDate, tempShift, tempSalary, tempBonus);
                }
                
                index++;
            }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error reading input file", "File Error", 2);
            System.exit(0);
        }
    }
    
  
    
    
    private String selectFileName(String purpose)
    {
        String fileName = "";
        JFileChooser chooser = new JFileChooser("");
        chooser.setDialogTitle(purpose);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) // checking to make sure a non-null value was returned
                                                     //  or that you did not just hit cancel
        {   
            fileName = chooser.getSelectedFile().getAbsolutePath();  // This will return the full 
                                                                     // path to the file
        }
        else
        {
            System.err.print("No file was chosen, program terminating");
            System.exit(0);
        }
        return fileName;
    }
    
    
    
    private void processUserResponse(String res)
    {
        String task = "";
        if( res.equals("A"))
        {
            String up_FirstName = "Enter the first name on which you would like to search\n single name only.\n\n";
            String name = JOptionPane.showInputDialog(null,up_FirstName, "Search on first name!\n", 1);
            String results = searchOnFirstName(name);
            JOptionPane.showMessageDialog(null, "Employees with the first name \""+name+"\" are as follows:\n\n"+results,"results",1);
        }
        else if( res.equals("B"))
        {
            String up_LastName = "Enter the last name on which you would like to search\n single name only.\n\n";
            String name = JOptionPane.showInputDialog(null,up_LastName,"Search on Last name!\n",1);
            String results = searchOnLastName(name);
            JOptionPane.showMessageDialog(null, "Employees with the last name \""+name+"\" are as follows:\n\n"+results,"Results",1);;
      
        }
        else if( res.equals("C"))
        {
            String[] options = {"Super", "Team Leader", "Prod.Work."};
            String up_position = "This option allows you to search by position.\nSelect the type of postition to search by\n ";
            int posCode =  JOptionPane.showOptionDialog(null,up_position,
                          "Search by Position",
                          JOptionPane.YES_NO_CANCEL_OPTION,
                          JOptionPane.QUESTION_MESSAGE,
                          null, options,options[0]);
            String results = "";
            switch(posCode)
            {   
                case 0:
                    results = searchForSuper();
                    break;
                case 1:
                    results = searchForTeamLeader();
                    break;
                case 2:
                    results = searchForProductionWorker();
                    break;
            }
            JOptionPane.showMessageDialog(null, "The following employees are \""+options[posCode]+"\":\n\n"+results,"Results",1);
        }
        else if( res.equals("D"))
        {
            String menu = "Enter the shift on which you would like to search\n\n"+
                          " 1- for first shift  8:00am-4:00pm.\n"+
                          " 2- for second shift 4:00pm-12:00am.\n"+
                          " 3- for third shift  12:am-8:am.\n"+
                          " 4- for weekend shift 6am - 6:pm Saturday and Sunday\n\n";
            
            String shift_string = JOptionPane.showInputDialog(null,menu, "Search on Last name", 1);
            int shift = Integer.parseInt(shift_string);
            String results = searchOnShift(shift);
            JOptionPane.showMessageDialog(null, "Employees working shift \""+shift+"\" are as follows:\n\n"+results,"Results",1);
      
        }else if( res.equals("E"))
        {
            String results = toString();
            JOptionPane.showMessageDialog(null, results,"Results",1);
      
        }
        else if( res.equals("Q"))
        {
            JOptionPane.showMessageDialog(null, "This program is now terminating","Program terminating",1);
            System.exit(0);
        }
        else
        {
            task = "Not a valid response!";
            JOptionPane.showMessageDialog(null, "Your entry was not a valid choice!", "Entry error", 1);
        }
    }
    
    
    
    private String getUserInputFromMenu(String add)
    {
        String Menu = add+ "\n\nEnter the letter cooresponding to the task required.\n\n" +
                            "A - to search on First name\n"+
                            "B - to search on Last name\n"+
                            "C - to search on position\n"+
                            "D - to search on shift\n"+
                            "E - to print all empolyees\n"+
                            "Q - to quit\n\n";
        
        String responseString = JOptionPane.showInputDialog(null, Menu, "Task Selection", 1);
        
        while (responseString == null || responseString.equals(""))
        {
            String error = "You have entered an invalid response\n\n";
            responseString = JOptionPane.showInputDialog(null, error+Menu, "Task Selection", 1);
        }
        
        return responseString.toUpperCase();
    }
    
    
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {  
            @Override public void run() {  

                FactoryEmployees fe = new FactoryEmployees();
                
            }  
        });     
    }
    
}
