**Metaspace**

Metaspace is a replacement for PermGen (Permanent Generation) introduced in Java 8.

**What does metaspace store?**
Metaspace stores metadata for runtime classes and application methods.
--> Static variables
--> Static methods
--> Metadata for classes

**More about the Heap?**

The heap is created when the JVM starts. The heap is generally divided into two parts. That is:

Young Generation(Nursery): **All the new objects** are allocated in this memory.
--> Whenever this memory gets filled, Minor Garbage Collection is performed. (To free up space from unused objects)

Old Generation: **Long-Lived Objects surviving rounds of Minor Garbage Collection** is transferred here.
--> Whenever this memory gets filled, Major Garbage Collection is performed.

## Note: String pool and constant pool have been moved to typical heap area, from Java 7 onwards.

---

PermGen Memory: Special space in Java Heap [called Non-Heap] storing 1) STATIC CONTENT 2) METADATA.

ISSUES:
--> Limited Size causing OutOfMemoryError (64-82MB).
--> Need either regular garbage collection (costly) or manual editing of size. (No auto-increasing of size)
--> Inefficient garbage collection.

---

Replacement: Metaspace is a new special space which LIVES IN NATIVE MEMORY (NOT HEAP MEMORY)
--> Much larger size (native memory >>> heap memory)
--> Auto-increase in size, depending on the OS
--> Efficient garbage collection. [Because no need for regular garbage collection. Larger bin --> Less regular cleaning --> More garbage cleaned for the same resources.]

Learn More Links:
https://www.geeksforgeeks.org/metaspace-in-java-8-with-examples/
https://www.baeldung.com/java-permgen-metaspace
