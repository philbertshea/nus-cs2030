package CS2030.Lec5Generics;

import CS2030.Lec5Generics.Burgers.*;
import CS2030.Lec5Generics.Geometry.*;
import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    /*
     * Given S is a subclass of T (S inherits T), S <: T --> S is a sub-type of T
     * --> COVARIANT: S[] <: T[]
     * Shape[] shapes = new Circle[10];
     * --> COVARIANT: S<E> <: T<E>
     * List<Point> PointList = new ArrayList<Point>(10);
     * --> INVARIANT: C<S> and C<T>
     * ERROR: ArrayList<Shape> shapes = new ArrayList<Circle>(10);
     */
    public static void main(String[] args) {

        // Java Collections require the parameterised type to be non-primitive.
        // Primitive types must use wrapper classes.
        // ArrayList<int> integers = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();

        // Gives an error
        // ArrayList<Circle> circles = new ArrayList<Point>(10);

        // To create an arraylist without error -- KNOWN TYPE = CIRCLE
        ArrayList<Circle> circles = new ArrayList<Circle>(10);
        ArrayList<Circle> circles2 = new ArrayList<>(10);
        List<Circle> circles3 = new ArrayList<>(10);

        // getObject(circles); // Error: ArrayList<Circle> is not a subtype of
        // List<Object>. Solution: use wildcard ?
        getWild(circles); // No problem when wildcard List<?> is used.
        // NOTE: ? is not a type. Cannot declare class SomeClass<?>

        List<Burger> burgers = new ArrayList<>(20);
        List<CheeseBurger> cheeseburgers = new ArrayList<>(20);
        List<HotDog> hotdogs = new ArrayList<>(20);

        getBurger(burgers);
        getBurger(cheeseburgers);
        // getBurger(hotdogs); // Error because HotDog is not a subtype of Burger,
        // hence does not conform to List<? extends Burger> requirement.

        getFastFood(burgers);
        getFastFood(cheeseburgers);
        getFastFood(hotdogs); // This is OK because HotDog implements ths interface FastFood

        // ? extends is covariant. If S <: T , C<S> <: C<? extends T>

        putBurger(burgers);
        // putBurger(cheeseburgers); // Error: CheeseBurger is a subclass of Burger, NOT
        // a superclass of Burger.
        // putBurger(hotdogs); // Error: HotDog implements FastFood but is not a
        // superclass of Burger (Burger is not a subclass of hotdog)

        putCheeseburger(burgers); // Burger is a superclass of CheeseBurger. Can add Cheeseburger (which is a
                                  // (subclass of) Burger) into list accepting Burgers
        putCheeseburger(cheeseburgers);
        // putCheeseburger(hotdogs); // Hotdog is not a superclass of Cheeseburger.
        // Cannot add Cheeseburher into list accepting Hotdogs.

        // This is possible now
        List<FastFood> fastfoodlist = new ArrayList<>();
        List<CheeseBurger> cheeseburgerlist = new ArrayList<>();
        getBurger(cheeseburgerlist); // burgerProducer: extends: accepts subclass of Burger
        putBurger(fastfoodlist); // burgerConsumer: super: accepts superclass of Burger

        System.out.println("The Fast Food List is: " + fastfoodlist);
    }

    private static void getObject(List<Object> myList) {
        int i = 0;

        for (Object element : myList) {
            i++;
            System.out.println("#" + i + " : " + element);
        }
    }

    // Use of wildcard List<?>
    private static void getWild(List<?> myWildList) {
        int i = 0;
        for (Object element : myWildList) {
            i++;
            System.out.println("#" + i + " : " + element);
        }
    }

    // Use of upper-bounded wildcard List<? extends Burger>
    /*
     * LOGIC: why extends?
     * PECS -- Producer Extends: the argument that getBurger takes in is a Producer
     * of burgers (get burger from burgerProducer). To get only a Burger,
     * getBurger should only accept a list containing Burgers or subclasses of
     * Burgers (e.g. cheeseburger)
     * and not any other instance (e.g. HotDog, which is not a Burger and hence
     * should not be printed in getBurger)
     */
    private static void getBurger(List<? extends Burger> burgerProducer) {
        int i = 0;
        System.out.println("Printing Order now...");
        for (Burger itemOrdered : burgerProducer) {
            i++;
            System.out.println("Order Item #" + i + " : " + itemOrdered);
        }
    }

    // Use of upper-bounded wildcard List<? extends FastFood>
    // Note that though FastFood is an interface, the convention for upper-bound
    // wildcards is ? extends X where X is a class or an interface.
    private static void getFastFood(List<? extends FastFood> FastFoodProducer) {
        int i = 0;
        System.out.println("Printing Order now...");
        for (FastFood itemOrdered : FastFoodProducer) {
            i++;
            System.out.println("Order Item #" + i + " : " + itemOrdered);
        }
    }

    // ? super Burger indicates that the List accepts any class that is a superclass
    // of Burger
    // ie any class/type that Burger is a subclass/subtype of.
    /*
     * LOGIC: why super?
     * PECS: Consumer super. putBurger adds in a Burger (or an instance which is a
     * subtype of Burger) into the list, which is taken in by putBurger as an
     * argument.
     * You can only insert a Burger into a list accepting Burger, or superclasses of
     * Burger (e.g. add Burger into List<FastFood> OK) but
     * not a list accepting only subclasses of Burger e.g. cannot add Burger into
     * List<cheeseburger> (which accepts only cheeseBurger or its sub-classes.)
     */
    private static void putBurger(List<? super Burger> burgerConsumer) {
        burgerConsumer.add(new Burger());
    }

    private static void putCheeseburger(List<? super CheeseBurger> cheeseburgerConsumer) {
        cheeseburgerConsumer.add(new CheeseBurger(3));
    }

    // Since the getAndPut method will require the list argument to be both a
    // burgerProducer and burgerConsumer. This is only possible if the List only
    // accepts Burger classes (and not any superclass/subclass which would violate
    // either requirement.)
    private static void getAndPutBurger(List<Burger> burgerList) {
        for (Burger burger : burgerList) {
            System.out.println(burger);
        }
        burgerList.add(new Burger());
    }
}
