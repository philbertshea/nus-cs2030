/* Binding is the connecting of a method called (usually in main driver) to method body. 
Static Binding: early binding, where the method call is linked to method body at compile time. Only for private, final or static members (methods and variables).
Static Binding uses Method Overloading
** Why? Static Binding gives a better performance as there is no overhead during runtime. Since private, final or static methods cannot be overridden,
they will always be accessed by objects of the local class. Hence binding can be done at compile time.

Dynamic Binding: late binding. Method call is connected to method body at runtime only.
Dynamic Binding uses Method Overriding
*/
package CS2030;

public class Lec3Slide16extra {
    public static class Person{
        void talk() {
            System.out.println("Hello.");
        }
        static void study() {
            System.out.println("Next time.");
        }
    }

    public static class Student extends Person {
        void talk() {
            System.out.println("Hey What's up.");
        }
        static void study() {
            System.out.println("ASAP.");
        }
    }

    public static void main(String[] args) {
        // At compile time, c is a Person. At runtime, c is a Student.
        Person a = new Person();
        Student b = new Student();
        Person c = new Student(); // This does not give an error, because a student is always a person. (Student is a subset of Person)
    // Student d = new Person(); // This gives an error, because a person is not always a student. (There exists cases where a Person is not a Student)

    // Dynamic Binding: For methods that are not private, final or static. Uses 
    System.out.println("Dynamic Binding: Person Student Student");
    a.talk();
    b.talk();
    c.talk();

    // Static Binding: E.g. static method study. c is treated as a Person (binding at compile time)
    // Technically since the method is static, we do not need to referebce it to an instance of Person/Student. Just for illustration Purposes.
    System.out.println("Static Binding: Person Student Person");
    a.study();
    b.study();
    c.study();
    }
    
}
