package CS2030Rec.Rec01_03;

// Method overloading supports a class to have more than one method
// of the same name or constructor WITH A CRITICAL REQUIREMENT:
// Overloaded methods CANNOT share the SAME ARGUMENT LIST. This means,
// They must have minimally one difference in the number, type or order of parameters.

public class Overloading_Methods {
}

class partA {
    // OK because the type of parameters is different
    // Therefore, overloading is ALLOWED
    public void f(int x) {
    }

    public void f(boolean y) {
    }
}

class partB {
    // Not OK because both methods take in one parameter of type int
    // Computer cannot distinguish which method to call on f(int)
    // Therefore, overloading leads to ERROR
    /*
     * public void f(int x) {}
     * public void f(int y) {}
     */

}

class partC {
    // Not OK because if the user calls f within the same class,
    // Computer cannot decide which method to call: private or public
    // Therefore, overloading leads to ERROR
    /*
     * private void f(int x) {}
     * public void f(int y) {}
     */

}

class partD {
    // Not OK because the user does NOT NEED TO assign a variable to f(int x)
    // i.e. "optional return". So the computer cannot decide which to call
    // if the user writes just f(int) Instead of int z = f(int)
    // Therefore, overloading leads to ERROR

    /*
     * public int f(int x) {
     * return x;
     * }
     * public void f(int y) {}
     */
}

class partE {
    // OK because order of parameters matters to computer
    // The computer can decide which f to call based on order of parameters.
    // Therefore, overloading is ALLOWED.

    public void f(int x, String s) {
    }

    public void f(String s, int y) {
    }
}