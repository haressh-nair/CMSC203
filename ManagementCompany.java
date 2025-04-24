/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: Management company class that handles up to 5 rental properties and calculates management fees based on rent.
 * Due: 04/23/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Haressh Nair
 */

public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Default constructor
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0.0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Constructor with company details
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Constructor with custom plot
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFeePer = otherCompany.mgmFeePer;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
        this.numberOfProperties = otherCompany.numberOfProperties;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return new Plot(plot);
    }

    public Property[] getProperties() {
        return properties;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public double getTotalRent() {
        double total = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    // Return property with highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        int maxIndex = getHighestRentPropertyIndex();
        return properties[maxIndex];
    }

    private int getHighestRentPropertyIndex() {
        double maxRent = Double.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > maxRent) {
                maxRent = properties[i].getRentAmount();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Add property by object
    public int addProperty(Property property) {
        if (property == null) return -2;
        if (isPropertiesFull()) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
        }

        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    // Add property(no plot info)
    public int addProperty(String name, String city, double rent, String owner) {
        Property property = new Property(name, city, rent, owner);
        return addProperty(property);
    }

    // Add property(with plot info)
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property property = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(property);
    }

    // toString method
    @Override
    public String toString() {

		String pStr = "List of the properties for " + name + ", " + "taxID: " + taxID + "\n";
		pStr += "______________________________________________________\n";

		for (int i = 0; i < properties.length && properties[i] != null; i++) {
			pStr += properties[i] + "\n";

		}
		pStr += "______________________________________________________\n";
		pStr += "\n total management Fee: " + (getTotalRent() * mgmFeePer) / 100;
		return pStr;
	}
    

}
