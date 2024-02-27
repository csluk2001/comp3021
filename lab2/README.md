# Lab 2: Classes, Objects

This lab will familiarize you with the following topics:

* Classes and Objects
* Static methods and variables
* Instance and static initializer blocks

## Classes and Objects

The meaning of class and object has not changed from C++ since COMP2012. This lab will help you get used to working with
classes and objects in Java.

## Static methods and variables

The meaning of static has not changed from C++ since COMP2012. Static methods and variables belong to the class, not a
specific object. They can be called via the class name. All instances of the class share the same static variables.

## Initialization blocks

By now, you've seen two ways of initializing variables:

* Field initializer

```java
class Person {
    String name = "John";
}
```

* Constructor

```java
class Person {
    String name;

    Person() {
        name = "John";
    }
}
```

However, it is also possible to initialize variables (both instance and static) using initialization blocks.

### Instance initialization blocks (IIB)

An instance initialization is executed in the following relative order:

1. All data fields initialized to default values (0, false, or null)
2. Field initializers and IIBs are executed according to the order of appearance
3. Body of the constructor executed after the body of parent constructor

```java
class Person {
    int age = 10;

    {
        age = 11;
    } //IIB

    Student() {
        age = 18;
    }
}
// age was 10, then 11, then finally 18
```

### Static initialization blocks (SIB)

Static initialization blocks are only run once, unlike IIBs, which are run each time an object is instantiated. SIBs are
run when the class is initialized by the JVM. An SIB is executed in the following relative order:

1. All static data fields are initialized to default values (0, false, or null)
2. Static field initializers and SIBs are executed according to the order of appearance

## Task of Lab2

In this lab, you will need to implement two simple Java classes and pass the given test cases.

The classes are about bus and bus company (like KMB).

- Bus class is a simple class that represents a bus with an ID and a model name.
- BusCompany class represents a bus company like KMB in Hong Kong, which can possess several buses with unique IDs and
  different models.
- BusCompany may be able to add new buses, remove all buses and get bus instances by its ID.

Detailed descriptions of the two classes can be found in the JavaDoc of the source code. 
What you need to do is implement the two classes according to the hints in the JavaDoc and pass all the provided test cases.


## Lab2 Submission

You need to submit exactly the **zipped** project file (i.e., `Lab2.zip`) to Canvas. An empty submission or submitting extra files will lead to a deduction of your lab score.