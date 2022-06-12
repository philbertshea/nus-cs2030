/* https://stackify.com/dependency-inversion-principle/
According to the Dependency Inversion Principle:
1. High-Level modules should not depend on low-level modules. Both High-level and Low-level modules should depend on abstractions.
2. Abstractions should not depend on details. Details should depend on abstractions.

Abstractions --> Interface to be implemented
Details --> Concrete implementations

E.G. Interfaces:                FilterCoffeeMaker             EspressoMaker    (Abstractions)
                                 ↑            ↑   implements  ↑
Concrete classes:  BasicCoffeeMachine        PremiumCoffeeMachine              (Low-Level Modules)
                                   ↑ parameter  ↑  
Application:                    CoffeeApp(XXMachine)                           (High-level Modules)
                                         ↑
User Interface:                 CoffeeAppStarter/UI                            (Higher-level Modules)
*/

package CS2030;

public class Lec4Slide18extra1 {

    // Interfaces are Abstractions.
    public interface FilterCoffeeMaker {
        public void brewFilterCoffee();
    }

    public interface EspressoMaker {
        public void brewEspresso();
    }

    // Concrete classes -- low-level modules BasicCoffeeMachine and
    // PremiumCoffeeMachine
    public class BasicCoffeeMachine implements FilterCoffeeMaker {
        @Override
        public void brewFilterCoffee() {
            System.out.println("Brew Filter Coffee");
        }

        public void addGroundCoffee() {
            System.out.println("Add ground coffee");
        }
    }

    public class PremiumCoffeeMachine implements FilterCoffeeMaker, EspressoMaker {
        @Override
        public void brewFilterCoffee() {
            System.out.println("Brew Filter Coffee");
        }

        @Override
        public void brewEspresso() {
            System.out.println("Brew Espresso");
        }

        public void addCoffeeBeans() {
            System.out.println("Add Coffee Beans");
        }
    }

    // Concrete classes -- high-level module CoffeeApp which takes in a machine as
    // parameter.
    public class CoffeeApp {
        private FilterCoffeeMaker machine;

        public CoffeeApp(FilterCoffeeMaker machine) {
            this.machine = machine;
        }

        public void makeCoffee() {
            this.machine.brewFilterCoffee();
        }
    }

    // Concrete classes -- higher-level module CoffeeAppStarter
    public class CoffeeAppStarter {
        PremiumCoffeeMachine nespresso = new PremiumCoffeeMachine();
        CoffeeApp app = new CoffeeApp(nespresso);
        
        {
        app.makeCoffee();
        }
    }

}
