package CS2030.Lec5Generics;

public class Burgers {
    public static interface FastFood {
        public void printCalories();
    }

    public static class Burger implements FastFood {
        public void munch(int numberOfTimes) {
            for (int i = 0; i < numberOfTimes; i++) {
                System.out.println("Om...nom...nom...");
            }
        }

        @Override
        public void printCalories() {
            System.out.println("This burger contains 600 calories.");
        }
    }

    public static class CheeseBurger extends Burger {
        int numberOfSlices;

        public CheeseBurger(int numberOfSlices) {
            this.numberOfSlices = numberOfSlices;
        }

        public void requestCheese() {
            System.out.println(numberOfSlices + "slices of cheese!");
        }

        @Override
        public void printCalories() {
            int calories = 600 + numberOfSlices * 50;
            System.out.println("This cheeseburger contains " + calories + " calories. A TIP: GET LESS CHEESE.");
        }
    }

    public static class HotDog implements FastFood {
        @Override
        public void printCalories() {
            System.out.println("This hotdog contains 300 calories.");
        }

    }
}
