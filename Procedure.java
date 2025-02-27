
/*
 * Class: CMSC203 
 * Instructor:Professor Monshi
 * Description: Procedure Information
 * Due: 02/24/2025
 * Platform/compiler:Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Haressh Nair
*/

public class Procedure {
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharges;

    //Constructor
    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitionerName = "";
        this.procedureCharges = 0.0;
    }
    // Constructor with only name and date
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    // Constructor with all attributes
    public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharges = procedureCharges;
    }

    // Accessor methods
    public String getProcedureName() { 
    	return procedureName; 
    	}
    public String getProcedureDate() { 
    	return procedureDate; 
    }
    public String getPractitionerName() { 
    	return practitionerName; 
    	}
    public double getProcedureCharges() { 
    	return procedureCharges; 
    	}

    // Mutator methods
    public void setProcedureName(String procedureName) { 
    	this.procedureName = procedureName; 
    	}
    public void setProcedureDate(String procedureDate) { 
    	this.procedureDate = procedureDate; 
    	}
    public void setPractitionerName(String practitionerName) { 
    	this.practitionerName = practitionerName; 
    	}
    public void setProcedureCharges(double procedureCharges) { 
    	this.procedureCharges = procedureCharges;
    	}

    //Display all information about the procedure.
    public String toString() {
        return "\nProcedures Information: "+"Procedure Name: " + procedureName + "\n" + "Date: " + procedureDate + "\n" + "Practitioner: " + practitionerName + "\n" + "Charges: $" +  procedureCharges+ "\n";
    }
}
