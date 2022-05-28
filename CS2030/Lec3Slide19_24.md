**Liskov Substitution Principle**

**Basics:** Liskov Substitution Principle basically states that If for each object o1 of type S there is an object o2 of type T such that for all programs P defined in terms of T, the behavior of P is unchanged when o1 is substituted for o2 then S is a subtype of T.
_Instances of a subclass must fulfill minimally the same properties of their subclass._

**Specific Rules**:
https://www.baeldung.com/java-liskov-substitution-principle#:~:text=The%20Liskov%20Substitution%20Principle,-4.1.&text=Barbara%20Liskov%2C%20defining%20it%20in,is%20a%20subtype%20of%20T.

1. Signature Rule – Method Argument Types
   This rule states that the overridden subtype method argument types can be **identical or wider** than the supertype method argument types.
   _Java requires **identical** arguments when overriding in subclass, so Fulfilled._

2. Signature Rule – Return Types
   The return type of the overridden subtype method can be **narrower** than the return type of the supertype method.
   _E.g. superclass func1() returns Number, subclass func1() returns int OK, Object NO_
   _Java requires **identical** return types for the subclass and superclass._

3. Signature Rule – Exceptions
   The subtype method can throw **fewer or narrower** _(but **NOT** any additional or broader)_ exceptions than the supertype method.

4. Properties Rule - Class Invariants

- A Class invariant is a (commented, not often coded) constraint that all properties of the class must adhere to.
- _E.G. Car speed < limit, Car speed >= 0, limit >= 0. Days >= 0_
- all subtype methods (inherited and new) must **maintain or strengthen** the supertype's class invariants.
- _E.G. Superclass Car speed < limit, Subclass HybridCar Charge > 0, speed < limit - 5 OK_

5. Properties Rule – History Constraint
   The subclass methods (inherited or new) **shouldn't allow state changes not allowed** in the base class.
   _E.G. Superclass Car mileage cannot be reset, Subclass ToyCar has reset function NO_

6. Methods Rule - Preconditions
   Precondition refers to a requirement imposed on parameters/properties of method before the main code in the method is run.
   A subtype can **weaken (but not strengthen)** the precondition for a method it overrides. [i.e. OK to relax constraints, but NO to tighten constraints]
   _E.G. Superclass Car FuelEfficiency(int EngineCapacity) where EngineCapacity range from 100-2000cc, Subclass HybridCar range from 100-3000cc OK, 500-800cc NO_

7. Methods Rule - Postconditions
   Postcondition refers to a requirement imposed on parameters/properties after the method is run.
   The subtype can **strengthen (but not weaken)** the postcondition for a method it overrides.
   _E.G. Superclass Car Brake() postcondition: speed decreases Subclass HybridCar Brake() postcondition: speed decreases charge increases OK speed increases NO_
