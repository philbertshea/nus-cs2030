Learn More Link: https://www.baeldung.com/java-generics 

**Generic Class**
class GenericClass <T> {

}

**Declaring instances of Generic Class**
List<Integer> list = new ArrayList<>(); // Remember that List is an interface, so List<>() does not compile.
List<Integer> list = new ArrayList<Integer>(); // OK but not needed.
SomeGenericClass<String> a = new SomeGenericClass<>();
SomeGenericInterface<String> b = new SomeGenericInterface<>(); // Not OK because an interface does not have a constructor.
SomeGenericInterface<String> b = new SomeGenericClass<>(); // OK iff SomeGenericClass implements SomeGenericInterface.

Given S is a subclass of T (S inherits T), S <: T --> S is a sub-type of T
--> COVARIANT: S[] <: T[]
Shape[] shapes = new Circle[10];
--> COVARIANT: S<E> <: T<E>
List<Point> PointList = new ArrayList<Point>(10);
--> INVARIANT: C<S> and C<T>
ERROR: ArrayList<Shape> shapes = new ArrayList<Circle>(10);

**Using the Wildcard in Generic Class**
--> Refer to Rec03_01 for more information.

**Generic Methods**
These are some properties of generic methods:

1. Generic methods have a **type parameter (the diamond operator enclosing the type) before the return type** of the method declaration.
2. Type parameters can be bounded (we explain bounds later in this article).
3. Generic methods can have **different type parameters separated by commas** in the method signature.
4. Method body for a generic method is just like a normal method.

Structure: Access_modifier [static_if_applicable] <T> Return_type method_name(method_parameters) {
return (Instance of Return type Return_type);
}

1: A generic method which takes in parameter input of type T and returns void.
public <T> void properPrint(T input) {
System.out.println("Proper print of input: " + input);
}

2: A generic method which takes in an array and returns an ArrayList.
public <T> List<T> fromArrayToList(T[] arr) {
List<T> newList = new ArrayList<>();
for(T el : arr) {
newList.add(el);
}
return newList;
}

// Alternatively, using Streams:
public <T> List<T> fromArrayToList(T[] a) {  
 return Arrays.stream(a).collect(Collectors.toList());
}

**Generic Methods with Multiple type parameters T and G**

3: A generic method which takes in parameters of types T and G and returns void
public <T,G> void printMultiple(T t, G g) {
System.out.println("Print a line consisting of two types T " + t + " and G " + g + " ! ");
}

4: A generic method which takes in a T[] array and a G[] array and returns an array of two Lists, List<T> and List<G>
public <T,G> List[] twoArraysToLists(T[] t, G[] g) { // Not the best possible implementation as List[] is a raw type.
List<T> TList = new ArrayList<>();
List<G> GList = new ArrayList<>();

    for (T el: t) {
        TList.add(el);
    }
    for (G ele: g) {
        GList.add(ele);
    }

    List[] arr = {TList, GList}
    return arr;

}

5: A generic, static method which takes in a T array and a mapper Function from T to G, and returns a List<G>.
public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
return Arrays.stream(a)
.map(mapperFunction)
.collect(Collectors.toList());
}

**Bounded Generics**
We can bound (restrict) the type parameter using an upperbound ONLY. <T extends SomeTypeOrSomeInterface>
This will restrict the method to accept SomeTypeOrSomeInterface and all its subclasses / all the classes/interfaces implementing the interface
NOTE: extends is always used even for interfaces. COMPLEMENTS is never used.

6: Method takes in a parameter which is an array of type T, where T must be Number or a subclass of Number.
It returns a List with the same type T (i.e. having the same upper bound restrictions)

public <T extends Number> List<T> fromArrayToList(T[] a) {
...
}

**Multiple Bounds in Bounded Generics**
--> Use & to set multiple bounds for T <T extends X & Y> ie T must be a subclass of X and Y
--> You can use certain interfaces like Comparable to gain access to specific methods, like CompareTo.

public <T extends Number & Comparable> List<T> fromArrayToList(T[] a) {
...
}


**Using Wildcards with Generics**
Though Object is the supertype of all Java classes, the collection of Object is NOT THE SUPERTYPE OF any collection.
I.E. Even if S <: T, List<S> NOT<: List<T>

7: Method paintAllBuildings accepts a List with type Building ONLY and returns void.
public static void paintAllBuildings(List<Building> buildings) {
    buildings.forEach(Building::paint);
}

However, the above implementation does not accept List<House> or List<OfficeTower> where House and OfficeTower are SUBTYPES of Building.
To solve this problem, we must use wildcard ?. The wildcard ? represents any type, and CAN BE STACKED WITH UPPER BOUNDS (EXTENDS) AND LOWER BOUNDS (SUPER)
*Note: ? does not represent an actual type, i.e. List<?> list = new ArrayList<>(); does NOT compile.*

8: Method paintAllBuildings accepts any List of type parameter Building or its subtype, and returns void.
public static void paintAllBuildings(List<? extends Building> buildings) {
    ...
}


**Type Erasure**
Generics were added to Java to ensure type safety. And to ensure that generics won't cause overhead at runtime, the compiler applies a process called type erasure on generics at compile time.

Type erasure **removes all type parameters** and replaces them with their *bounds* or with *Object* if the type parameter is unbounded. This way, the bytecode after compilation contains only normal classes, interfaces and methods, ensuring that no new types are produced. Proper casting is applied as well to the Object type at compile time.

9: Illustration of type erasure:

// Typed Code
public <T> List<T> genericMethod(List<T> list) {
    return list.stream().collect(Collectors.toList());
}

// With type erasure, **UNBOUNDED TYPE PARAMETER T is replaced with Object**

// After Type Erasure (After Compilation), the computer converts the code to...
public List<Object> withErasure(List<Object> list) {
    return list.stream().collect(Collectors.toList());
}

// A type parameter of Object in practice results in...
public List withErasure(List list) {
    return list.stream().collect(Collectors.toList());
}

--------------------
// Typed Code
public <T extends Building> void genericMethod(T t) {
    ...
}

// With type erasure, after compilation **BOUNDED TYPE T IS REPLACED BY ITS BOUND, I.E. BUILDING**
public void genericMethod(Building t) {
    ...
}



**Primitive Data Types are NOT ACCEPTED as type parameters in Generics**
Generics is a compile-time feature. Upon compilation, due to type erasure, all generic types will be replaced by Object.
However, primitive types DO NOT EXTEND OBJECT. Therefore, they cannot be used as type parameters in Generics.
Instead, we can use Wrapper classes (but these take more time to load).

10: Illustration of Primitive and Wrapper Classes

// Returns an error because int is a primitive type and hence cannot be a Generic Data type.
List<int> intList = new ArrayList<>(); 
intList.add(17);

Where signature of add is: boolean add(E e) 
--> On Type Erasure, it turns to  boolean add(Object e). 
Since int does not extend Object, int is not accepted.

// Instead: we can use a wrapper class Integer.
List<Integer> IntegerList = new ArrayList<>(); 
IntegerList.add(17);
int first = IntegerList.get(0);

(When 17 is used as a parameter input of type Integer, the following occurs:
Integer a = 17; // Autoboxing
int b = a; // Unboxing)


// This is the equivalent of:
List IntegerList = new ArrayList<>();
IntegerList.add(Integer.valueOf(17));
int first = ((Integer) IntegerList.get(0)).intValue();
