Quick Summary Link: https://www.youtube.com/watch?v=dH2LG3wxXbQ&ab_channel=Geekific

Learn More Link: https://www.baeldung.com/java-stack-heap

1. Call Stack: Stores Information about Active Sub-routines of Computer Program
2. Stack Memory: Stores Primitive Values of variables (int x = 1) and References to objects in the heap (Integer y, String z).
3. Heap Memory: Stores New Objects (e.g. new Circle(1)), values of non-primitive variables ((stack) z ---> "Hello" (heap)).

**Key features of Stack Memory** - Static memory allocation and thread execution.

--> Last-In First-Out (Stack). Whenever we call a new method, a new block is created on top of the stack which contains values specific to that method, like primitive variables and references to objects.
--> When the method finishes execution, its corresponding stack frame is flushed, the flow goes back to the calling method, and space becomes available for the next method.

- It grows and shrinks as new methods are called and returned, respectively.
- Variables exist WHEN METHODS CREATING THEM ARE RUNNING.
- It's automatically allocated and deallocated when the method finishes execution.
- If this memory is full, Java throws java.lang.StackOverFlowError.
- FAST ACCESS TO MEMORY
- THREADSAFE, as each thread operates in its own stack.

**Key features of Heap Memory** - Dynamic memory allocation of Java objects and JRE classes at runtime
--> Young Generation: Allocate new objects. Minor garbage collection when filled.
--> Old Generation: When objects in Young Generation age past a certain threshold, they are moved to Old Generation.
--> Permanent Generation: JVM metadata for runtime classes and application methods. 
**PermGen is now changed to Metaspace. Refer to Metaspace.md for more details**

- It's accessed via complex memory management techniques that include the Young Generation, Old or Tenured Generation, and Permanent Generation.
- If heap space is full, Java throws java.lang.OutOfMemoryError.
- LARGER SPACE than Stack.
- SLOW ACCESS TO MEMORY
- No automatic deallocation. Needs Garbage Collector to free up unused objects.
- NOT THREADSAFE and needs to be guarded by properly synchronizing the code.

**Memory Management in Code**

class Person {
int id;
String name;

    public Person(int id, String name) {                C C3 D
        this.id = id;                                   C1
        this.name = name;                               C2
    }

}

public class PersonBuilder {
private static Person buildPerson(int id, String name) { B2 B3
return new Person(id, name);                            C 
}

    public static void main(String[] args) {            A
        int id = 23;                                    A1
        String name = "John";                           A2
        Person person = null;                           A3
        person = buildPerson(id, name);                 B B1 D
    }

}

**Step-by-step**
A: When entering main() method, a main block is created in call stack and a space created in stack memory to store **primitives and references of main(String[]) method - id, name, person**.
A1 --> Stack memory directly stores primitive value of id (id = 23)
A2 --> Reference variable name is created in stack memory. Meanwhile, "John" is created in string pool of Heap Memory. **Reference variable name (Stack memory) points to its value "John" (Heap Memory)**
A3 --> Reference variable person of type Person is created in stack memory. Currently not pointing to anything.

B: Main calls buildPerson(id, name) static method. A buildPerson block is stacked onto call stack, corresponding to a new space created in stack memory to store primitives and references - id, name, person.
B1 --> Stack memory: create reference variable person (which stores what the buildPerson method returns). Not pointing anywhere.
B2 --> Stack memory: store primitive value id = 23
B3 --> Stack Memory: create reference variable name, pointing to (existing) value "John" in Heap Memory.

C: buildPerson calls Person(id, name) constructor. A Person block is stacked onto call stack. A new space on top of stack memory to store primitives and references - id, name, this
C1 --> Stack Memory: Store primitive value of id = 23
C2 --> Stack Memory: create reference variable name, pointing to (existing) value "John" in Heap Memory.
C3 --> Stack Memory: create reference variable this. Heap Memory: Create new Person object of id = 23 and name = "John". **Reference variable this (Stack memory) points to the new Person object [id=23, name="John"] (Heap memory)**

*Note: the Person object contains only primitive values (id = 23) and references to non-primitive values (name, pointing to "John" in Heap Memory String pool).*

D: All reference variables person in previous two blocks of stack memory will now point to the new Person object in the Heap Memory.

-- Removing blocks --

E: When the Person constructor fininshes execution, the Person block is removed from the call stack, together with the corresponding block on top of the stack memory. 
--> The link from this to the Person object is removed, but THE PERSON OBJECT REMAINS INTACT AT THE HEAP MEMORY.

F: When the buildPerson constructor finishes execution and returns the Person object to person variable in main, the buildPerson is removed from the call stack. The corresponding block on top of the stack memory is removed as well.
--> The link from person (in buildPerson) to the Person object is removed, but THE PERSON OBJECT REMAINS INTACT AT THE HEAP MEMORY.

G: When the main constructor finishes execution, the main block is removed from the call stack and the last, corresponding block in Stack Memory is removed. 
--> The Person object and value of name, "John", are removed from the Heap memory as well. The code ends execution.