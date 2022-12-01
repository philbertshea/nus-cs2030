**Overload or Override?**

Guidebook: 1- Inherit from supertype
Else, if a separate implementation OF SAME NAME METHOD is used in subtype: Return type / Parameter Structure
2 - Same/Same: Override
3 - Same/Different: Overload
4 - Same/Same + Same/Different: Override and Overload
5 - Different/Same: ERROR - fail to override
6 - Different/Different: Overload

---------------- NO RE-IMPLEMENTATION OF SAME-NAMED METHOD ------------------------

*Case 1: Inherit from supertype. 
- class A { void f() { System.out.println("A"); } }
- class B extends A {}
- Automatically, class B inherits f() from A. 
--> B b = new B();  b.f() - "A"
--> A a = b;        a.f() - "A"
--> a = new A();    a.f() - "A"

---------------- WITH RE-IMPLEMENTATION OF SAME-NAMED METHOD -----------------------

*Case 2: Override.  METHOD HAS **SAME RETURN TYPE AND SAME PARAMETER STRUCTURE**
- class A { void f() { System.out.println("A"); } }
- class B extends A { void f() { System.out.println("B"); }}

- Type B's f() OVERRIDES type A's f().
- Whenever a variable of RUNTIME TYPE B calls method f, USE THE OVERRIDDEN METHOD
- "Invisible" @Override

--> B b = new B();  b.f() - "B"
--> A a = b;        a.f() - "B"
--> a = new A();    a.f() - "A"



*Case 3: Overload.  METHOD HAS **SAME RETURN TYPE BUT DIFFERENT PARAMETER STRUCTURE**
- class A { void f() { System.out.println("A"); } }
- class B extends A { void f(int x) { System.out.println("Number: " + x); }}

- Type B's f() OVERLOADS type A's f().
- It is ALLOWED for a method to have OVERLOADED VERSIONS OF ITSELF. This means
1. **Same Return Type** As Original in Supertype's Implementation. (**IT IS ALLOWED TO HAVE DIFFERENT RETURN TYPE, SEE CASE 6**)
2. Different Number, Type or Order of Parameters

- Whenever a variable of RUNTIME TYPE B calls method f:
a. If f(), Use the SUPERTYPE (A) IMPLEMENTATION 
b. If f(int x), Use the OVERLOADED IMPLEMENTATION IN SUBTYPE B

* Note: If Compile Type is A, COMPILE ERRORS may occur when calling OVERLOADED METHODS UNIQUE TO SUBTYPE B

--> B b = new B();  b.f() - "A"
--> b = new B()     b.f(10) - "Number: 10"
--> A a = b;        a.f(10) - COMPILE ERROR (Compile-type of a is A --> No access to f(int))
--> a = new A();    a.f() - "A"
--> a = new A();    a.f(10) - COMPILE & RUN ERROR.


*Case 4: Override and Overload.  METHOD HAS **SAME RETURN TYPE AND SAME + DIFFERENT PARAMETER STRUCTURE**
- class A { void f() { System.out.println("A"); } }
- class B extends A { void f() { System.out.println("B"); }
                      void f(int x) { System.out.println("Number: " + x); }}

- Whenever a variable of RUNTIME TYPE B calls method f:
a. If f(), Use the OVERRIDDEN IMPLEMENTATION IN SUBTYPE B
b. If f(int x), Use the OVERLOADED IMPLEMENTATION IN SUBTYPE B


--> B b = new B();  b.f() - "B"
--> b = new B()     b.f(10) - "Number: 10"
--> A a = b;        a.f(10) - COMPILE ERROR 
--> a = new A();    a.f() - "A"
--> a = new A();    a.f(10) - COMPILE & RUN ERROR.




*Case 5: FAIL TO OVERRIDE --> COMPILE ERROR.  METHOD HAS **DIFFERENT RETURN TYPE BUT SAME PARAMETER STRUCTURE**
- class A { void f() { System.out.println("A"); } }
- class B extends A { int f() { return 0; }}

- To **OVERRIDE**, it is a MUST TO HAVE:
1. Same return type.
2. Same Parameter Structure.

**B.f() has SAME PARAMETER STRUCTURE WHICH INDICATES INTENT TO OVERRIDE, NOT OVERLOAD.**
But B.f() has a different return type than A.f(), hence B.f() fails to override A.f()




*Case 6: Overload.  METHOD HAS **DIFFERENT RETURN TYPE AND DIFFERENT PARAMETER STRUCTURE**
- class A { void f() { System.out.println("A"); } }
- class B extends A { int f(int x) { return x+1; }}

- Type B's f() OVERLOADS type A's f().
- Overloading Criteria is just to have **Different Number, Type or Order of Parameters**.
- No restriction is placed on the return type.

- Whenever a variable of RUNTIME TYPE B calls method f:
a. If f(), Use the SUPERTYPE (A) IMPLEMENTATION 
b. If f(int x), Use the OVERLOADED IMPLEMENTATION IN SUBTYPE B


--> B b = new B();  b.f() - "A"
--> b = new B()     b.f(10) - 11
--> A a = b;        a.f(10) - COMPILE ERROR (Compile-type of a is A --> No access to f(int))
--> a = new A();    a.f() - "A"
--> a = new A();    a.f(10) - COMPILE & RUN ERROR.