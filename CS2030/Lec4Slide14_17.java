package CS2030;

// According to the Interface Segregation Principle, No client should be forced to depend on methods it does not use.

public class Lec4Slide14_17 {

    // Note that an interface merely indicates the methods contained, but not the
    // actual code and implementation.
    public interface MummysBoy {
        public String hi();
    }

    public interface Romantic {
        public String hey();
    }

    public interface PartyAnimal {
        public String supp();
    }

    // One class can implement multiple interfaces, but not every instance of Me
    // might want to depend on all three interfaces.
    // By the Interface Segregation Principle, if the instance only needs to depend
    // on one interface, then restrict its access to only the methods from one
    // interface.
    public static class Me implements MummysBoy, Romantic, PartyAnimal {
        @Override
        public String hi() {
            return "Hi mum";
        }

        @Override
        public String hey() {
            return "Hey gf";
        }

        @Override
        public String supp() {
            return "Supp dude";
        }
    }

    public static void main(String[] args) {
        Me meAll = new Me();
        System.out.println("meAll can access all methods.");
        System.out.println(meAll.hi());
        System.out.println(meAll.hey());
        System.out.println(meAll.supp());

        MummysBoy meMummysboy = meAll;
        System.out.println(
                "Since meMummysboy is declared as an instance of MummysBoy, it can only access restricted methods of Mummysboy.");
        System.out.println(meMummysboy.hi());
        /*
         * hey() and supp() below do not work.
         * System.out.println(meMummysboy.hey());
         * System.out.println(meMummysboy.supp());
         */

    }
}
