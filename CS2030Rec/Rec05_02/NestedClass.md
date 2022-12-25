Learn more Link: https://www.geeksforgeeks.org/anonymous-inner-class-java/ 

**Nested Class**

class OuterClass
{
...
    class NestedClass
    {
        ...
    }
}

- Scope of NestedClass is bound by Scope of OuterClass. 
- NestedClass cannot exist independently of OuterClass.
- NestedClass can ACCESS MEMBERS OF OuterClass (Including Private members). But OuterClass CANNOT ACCESS MEMBERS of NestedClass.
- NestedClass IS A MEMBER OF OuterClass --> NestedClass can be declared private, public, protected or default.
- As a member of its enclosing class, a nested class can be declared private, public, protected, or package private(default).

Nested classes are divided into two categories:
- static nested class : Nested classes that are declared static are called static nested classes.
- inner class : An inner class is a non-static nested class.
