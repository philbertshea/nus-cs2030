// Preventing Inheritance and/or Overriding


package CS2030;

public class Lec4Slide24 {
    // This class is marked as final, hence no class can inherit from it.
    public final class DoNotInherit {
        double x;
        public DoNotInherit(double x) {
            this.x = x;
        }

        public double getX() {
            return x;
        }
    }


    /* public class WantToInherit extends DoNotInherit {

    } */

    public class CanInherit {
        double y;
        public CanInherit(double y) {
            this.y = y;
        }
        
        public double canOverride() {
            return y;
        }

        // This method is marked as final, hence it cannot be overriden in the subclasses of CanInherit.
        public final double doNotOverride() {
            return 10;
        }
    }

    public class Subclass extends CanInherit {
        double z;

        public Subclass(double z) {
            super(z);
        }

        @Override
        public double canOverride() {
            return z+10;
        }

        
        /* @Override
        public double doNotOverride() {
            return 20;
        } */

    }
}
