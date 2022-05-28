package CS2030;

class Fruit {
    // class invariant: price > 0
    // constraint: qtySold cannot be reset
    private int price;
    private String name;
    protected int qtySold;

    public Fruit(int price, String name, int qtySold) {
        this.price = price;
        this.name = name;
        this.qtySold = qtySold;
    }
}

// Rule 4: the class invariant constraint from the superclass must be preserved
// in the subclass.
// Rule 5: the history constraint from the superclass must be preserved in the
// subclass.
class Apple extends Fruit {
    // class invariant: price > 0, origin not null
    private final String origin;

    public Apple(int price, String name, int qtySold, String origin) {
        super(price, name, qtySold);
        this.origin = origin;
    }

    // History invariant: qtySold cannot be reset in the subclass, coherent with the
    // constraint in Fruit
    // Though no error, it violates the substitutability rule.
    public void Reset() {
        this.qtySold = 0;
    }

}

// Rule 6: preconditions - the parameters of overridden methods in subclass must
// be weaker or identical in range to superclass
// Rule 7: postconditions - after overridden methods are run, the constraints in
// resultant values of variables must be stronger or identical to superclass.
class Stationery {
    protected double price;

    public Stationery(double price) {
        this.price = price;
    }

    // Precondition: percentage > 10%
    // Postcondition: newprice > existing price
    public double IncreasePrice(double percentage) {
        if (percentage <= 10) {
            return this.price;
        }
        double newprice = this.price * (1 + percentage / 100);
        this.price = newprice;
        return newprice;
    }
}

class Pencil extends Stationery {
    private String name;

    public Pencil(int price, String name) {
        super(price);
        this.name = name;
    }

    // Precondition: percentage > 0% (Weaker)
    // Postcondition: newprice > existing price + $1 (Stronger)
    @Override
    public double IncreasePrice(double percentage) {
        if (percentage <= 0) {
            return this.price;
        }
        double newprice = this.price * (1 + percentage / 100) + 1;
        this.price = newprice;
        return newprice;
    }
}

public class Lec3Slide19_24_b {

}
