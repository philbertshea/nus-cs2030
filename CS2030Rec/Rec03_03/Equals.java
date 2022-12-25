/* Recall that the == operator compares only references, i.e. whether the two references
are pointing to the same object. On the other hand, the equals method is more
flexible in that it can override the method specified in the Object class.
In particular, for the Integer class, the equals method has been overridden to com-
pare if the corresponding int values are the same or otherwise. */

// More details: https://www.baeldung.com/java-equals-method-operator-difference


// Learning Point: == compares references while equals compares values (for Integer). Equals cannot be used on primitives
// Due to integer caching for -128 to -127, Integer==Integer gives the same result as Integer.equals(Integer) ONLY FOR THIS RANGE.
// Outside of this range, Integer==Integer only returns true for same reference (e.g. a= 1000 b=a). Best to use equals.

package CS2030Rec.Rec03_03;

public class Equals {
    public static void main(String[] args) {
        // For primitive integers, int==int which checks references is essentially equivalent to checking the values of two numbers
        System.out.println("int==int returns true if both integers are the same number");
        int a = 1;
        int b = 1;

        System.out.println(a == b); 
        // System.out.println(a.equals(b)); // Equals cannot be used on primitive types like int.
        
        System.out.println("Even after changing to a different number, int==int still returns the expected result");
        a = 1000;
        b = 1000;
        System.out.println(a == b); 

        // For wrapper class Integer, Integer Caching works by reusing an integer instance 
        // for multiple variables with the same integer value. Therefore Integer==Integer compares numbers correctly.
        System.out.println("Integer.equals(Integer) ALWAYS RETURNS TRUE if both integers are the same number");
        System.out.println("Integer==Integer checks references");
        Integer x = 1;
        Integer y = 1;

        System.out.println(x == y);
        System.out.println(x.equals(y));

        // However, Integer Caching is 1) only available for integers of range -128 to 127 and 2) applies only for autoboxing (ie wrapper class Integer).
        // Hence for integers outside of range -128 to 127, variables with the same integer will not share the same instance and hence have different references 
        // --> Integer==Integer returns false.
        x = 1000;
        y = 1000;
        System.out.println(x == y);
        System.out.println(x.equals(y));
    }
}