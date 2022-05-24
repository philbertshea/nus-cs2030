package AccessModifiers.Package1;

import AccessModifiers.Package1.Access1.*;

public class Access2 {
    // Case 2b: Subclass in DIFFERENT FILE, SAME PACKAGE. Default, Public, Protected OK. Private NO.
    public class MotorCycle extends Vehicle {

        public MotorCycle(int year, double mileage, boolean toBeScrapped, double COE) {
            super(year, mileage, toBeScrapped, COE);
            // Note that an error is produced here. This is because onstructor of Vehicle cannot be accessed without being referenced to an instance of Access1.
            // To solve this problem, need to make the NESTED CLASS Vehicle in Access1 static. This is so that Vehicle (and its methods/constructor/properties etc.)
            // can be used simply by CREATING AN INSTANCE OF VEHICLE, without referencing to the Access1 class.
        }
        
        public void claimInsurance() {
            year = 2020;
            mileage = 1000;
            // toBeScrapped = false;
            COE = 1000;
        }
        
    }

    public static void main(String[] args) {
        Access1 obj1 = new Access1();
        Vehicle car1 = new Vehicle(2018, 10000, false, 20000);
        // IF Vehicle(Access1) nested class is public:
        // Note that if we just use "new Vehicle...", an error will pop up stating: "No enclosing instance of type Access1 is accessible."
        // This is because Vehicle is NOT A STATIC CLASS.
        // Static can be applied to a variable, method, block or nested class. A static keyword is shared in the class,
        // and does NOT belong to any instance of the class. Hence, a static method can be ACCESSED WITHOUT CREATING AN INSTANCE/OBJECT of the class.
        // Since Vehicle is NOT STATIC, it must belong to (and be referenced with) some object of type Access1. Hence obj1.new 
        // (i.e. car1 belongs to obj1. Properties of car1 are only accessible by obj1 and not elsewhere.

        // IF Vehicle(Access1) nested class is public static:
        // We can only use "new Vehicle..." but NOT "obj1.new Vehicle..."
        // This is because the properties of nested class NO LONGER BELONGS TO ONE INSTANCE OF ACCESS1, but rather is SHARED AMONG ALL ACCESS1 INSTANCES
        // Static variables cannot be used alongside non-static (instance) variables. hence obj1.new will NOT WORK.
        
        
        // Case 3: Other class in SAME PACKAGE. Default, public, protected OK. Private NO.
        obj1.name = "Apple";
        obj1.PlaceOfOrigin = "Korea";
        // obj1.productionCost = 10;
        obj1.price = 100;

        car1.year = 1000;
        car1.mileage = 1000;
        // car1.toBeScrapped = true;
        car1.COE = 50000;
    }
    
}
