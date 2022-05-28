package CS2030;

class Car {
    protected double mileage;
    protected final int year;
    protected final String name;

    public Car(double mileage, int year, String name) {
        this.mileage = mileage;
        this.year = year;
        this.name = name;
    }

    public Number calcCOEEnd(int year) {
        return year + 10;
    }
    
}

class HybridCar extends Car{
    // The subclass constructors can have identical or more parameters, but NOT FEWER parameters
    
    /* NOT OK: Remove mileage
    public HybridCar(int year, String name) {
        super(year, name);
    } */

    // OK: Keep existing and Add ChargeCapacity
    private final int ChargeCapacity;

    public HybridCar(double mileage, int year, String name, int ChargeCapacity) {
        super(mileage, year, name);
        this.ChargeCapacity = ChargeCapacity;
    }  // OK



    // Rule 1. The subclass overriden method can have identical or more parameters, but NOT FEWER parameters
    // Rule 2. The subclass overridden method can return an identical or narrower type, but not a WIDER type.
    // Note: for Rules 1 and 2, Java requires identical parameters and return type, so automatically fulfilled.

    /* NOT OK in theory and Java. Wider return type + Less Parameters
    @Override
    public Object calcCOEEnd() {
        return this.year + 10;
    }
    */

    /* OK in theory, NOT OK in Java: Narrower return type + More Parameters 
    @Override
    public int calcCOEEnd(int year, double YearsLeft) {
        return year + 10 - YearsLeft;
    }
    */
    
    @Override
    public Number calcCOEEnd(int year) {
        return year + 11;
    }

    // NOTE THAT The Theoretically OK version works if no @override used. But this becomes an OVERLOADED method
    // Meaning that calcCOEEnd has two editions. E.g. if calcCOEEnd(1 param) method called, it will be statically
    // binded to the overridden method (or superclass method if no overridden method)

    public int calcCOEEnd(int year, double YearsLeft) {
        return year + 10 - (int) YearsLeft; // recommended to just use int YearsLeft on top, unless you expect double YearsLeft param.
    }

}



public class Lec3Slide19_24_a {
    
}
