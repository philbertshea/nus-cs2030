package AccessModifiers.Package2;

import AccessModifiers.Package1.Access1.*;

// OK to import from other packages.

public class Access3 {
    public static class Sedan extends Vehicle {

        public Sedan(int year, double mileage, boolean toBeScrapped, double COE) {
            super(year, mileage, toBeScrapped, COE);
        }

        // Case 4: Subclass from other package. Public, Protected OK. Default, Private
        // NO.
        public void printStats() {
            // System.out.println("This is a Sedan produced in [Default]" + year);
            System.out.println("Its mileage in km is [Public]" + mileage);
            // System.out.println("It's relatively new so the recommendation to scrap it is
            // [Private]" + toBeScrapped);
            System.out.println("COE paid was not low at [Protected] " + COE);
        }

    }

    public static void main(String[] args) {
        Sedan car2 = new Sedan(2000, 100000000, true, 5000);

        // Case 5: Other class from other package. Public OK. Default, Private,
        // Protected NO.
        // System.out.println("This is a Sedan produced in [Default]" + car2.year);
        System.out.println("Its mileage in km is [Public]" + car2.mileage);
        // System.out.println("It's relatively new so the recommendation to scrap it is
        // [Private]" + car2.toBeScrapped);
        // System.out.println("COE paid was not low at [Protected] " + car2.COE);
    }
}
