/*
 * Class: CMSC203 
 * Instructor:Professor Monshi
 * Description: Patient Information
 * Due: 02/24/2025
 * Platform/compiler:Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Haressh Nair
*/


public class Patient {
	//Declaring variables
    private String firstName, middleName, lastName;
    private String streetAddress, city, state, zipCode;
    private String phoneNumber;
    private String emergencyContactName, emergencyContactPhone;

    public Patient() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
        this.phoneNumber = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }

    // Constructor with only name fields
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Constructor with all attributes
    public Patient(String firstName, String middleName, String lastName, String streetAddress, String city, String state, String zipCode, String phoneNumber, String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Accessor methods
    public String getFirstName() {
    	return firstName; 
    	}
    public String getMiddleName() { 
    	return middleName; 
    	}
    public String getLastName() { 
    	return lastName; 
    	}
    public String getStreetAddress() { 
    	return streetAddress; 
    	}
    public String getCity() { 
    	return city; 
    	}
    public String getState() { 
    	return state; 
    	}
    public String getZipCode() { 
    	return zipCode; 
    	}
    public String getPhoneNumber() { 
    	return phoneNumber; 
    	}
    public String getEmergencyContactName() { 
    	return emergencyContactName; 
    	}
    public String getEmergencyContactPhone() { 
    	return emergencyContactPhone; 
    	}

    // Mutator methods
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    	}
    public void setMiddleName(String middleName) { 
    	this.middleName = middleName; 
    	}
    public void setLastName(String lastName) { 
    	this.lastName = lastName; 
    	}
    public void setStreetAddress(String streetAddress) { 
    	this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; 
    }
    public void setState(String state) { 
    	this.state = state; 
    	}
    public void setZipCode(String zipCode) { 
    	this.zipCode = zipCode; 
    	}
    public void setPhoneNumber(String phoneNumber) { 
    	this.phoneNumber = phoneNumber; 
    	}
    public void setEmergencyContactName(String emergencyContactName) { 
    	this.emergencyContactName = emergencyContactName; 
    	}
    public void setEmergencyContactPhone(String emergencyContactPhone) { 
    	this.emergencyContactPhone = emergencyContactPhone; 
    	}

    // Method to build full name
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Method to build full address
    public String buildAddress() {
        return streetAddress + ", " + city + ", " + state + " " + zipCode;
    }

    // Method to build emergency contact details
    public String buildEmergencyContact() {
        return emergencyContactName + " (" + emergencyContactPhone + ")";
    }

    //Display all information about the Patient.
    public String toString() {
        return "\nPatient Information:\n" + "Name: " + buildFullName() + "\n" + "Address: " + buildAddress() + "\n" + "Phone: " + phoneNumber + "\n" + "Emergency Contact: " + buildEmergencyContact();
    }
}
