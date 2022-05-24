// Go through the four different types of Access Modifiers: default, public, protected, private
package AccessModifiers.Package1;

public class Access1 {
    String name;
    public String PlaceOfOrigin;
    private double productionCost;
    protected double price;

    public static class Vehicle {
        // default access modifier: accessible in SAME PACKAGE
        int year;

        // public access modifier: accessible anywhere
        public double mileage;

        // private access modifier: accessible ONLY in SAME CLASS, SAME PACKAGE
        private boolean toBeScrapped;

        // protected access modifier: accessible in SAME PACKAGE AND as subclass IN OTHER PACKAGES
        protected double COE;
        
        public Vehicle(int year, double mileage, boolean toBeScrapped, double COE) {
            this.year = year;
            this.mileage = mileage;
            this.toBeScrapped = toBeScrapped;
            this.COE = COE;
        }

        // Case 1: Same Class. All OK
        public void reportScrappableVehicle() {
            year = 2010;
            mileage = 1000000;
            toBeScrapped = true;
            COE = 10000;
        }

    }


    // Case 2a: Subclass in SAME FILE. Default, Public, Protected OK. Private NO.
    public class MotorCycle extends Vehicle {

        public MotorCycle(int year, double mileage, boolean toBeScrapped, double COE) {
            super(year, mileage, toBeScrapped, COE);
        }
        
        public void claimInsurance() {
            year = 2020;
            mileage = 1000;
            toBeScrapped = false;
            COE = 1000;
        }
        
    }

}
