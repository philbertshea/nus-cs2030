package CS2030Rec.Rec03_04;

// My guess: Since the constructor raises the value of static variable b by 1,
// and the constructor is called two times, x.b = y.b = PartC.b (Class variable) = 2

// Answer: Returns 2 2 
/* Although it seems there are two different classes, C<Integer> and C<String>,
there is still only one class C. There is only one copy of the class variable b. */

public class PartC<T> {
    static int b = 0;

    PartC() {
        this.b++;
    }

    public static void main(String[] args) {
        PartC<Integer> x = new PartC<>();
        PartC<String> y = new PartC<>();
        System.out.println(x.b);
        System.out.println(y.b);
    }
}
