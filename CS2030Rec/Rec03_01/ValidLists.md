
Given S is a subclass of T (S inherits T), S <: T --> S is a sub-type of T
--> COVARIANT: S[] <: T[]
Shape[] shapes = new Circle[10];
--> COVARIANT: S<E> <: T<E>
List<Point> PointList = new ArrayList<Point>(10);
--> INVARIANT: C<S> and C<T>
ERROR: ArrayList<Shape> shapes = new ArrayList<Circle>(10);


Learning Point: For List<? [+ Restrictions]> list = new SomeList<Y>();
Points required for Compilation: 
1. If there are restrictions behind the wildcard ? in List<>, Y must fulfill these restrictions.
e.g. List<? super Integer> --> Y must be Integer or a supertype of Integer
2. SomeList must be a class implementing java's List interface. SomeList cannot be List itself.
e.g. List NOT OK [List is an interface]  LinkedList or ArrayList OK.
3. Y must be a Reference type, e.g. Integer not int.