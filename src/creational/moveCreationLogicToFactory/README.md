# What is the motivation behind it?

1. Creation of the object is spread across multiple classes.
2. If the client cannot access the object's creation code, because it is moved far away from client to a different layer, then it is very difficult for the client to create the object with different configurations

# Solution

Factory design pattern will be helpful because the entire creation logic now resides at one place. 

# Choices

* Make the current class implement a Factory interface.
* If the creation logic becomes too complex, due to supporting too many __creating options__ then it makes sense to abstract the creation logic to a static factory.
Once that is done the client can then configure the system with a __Concrete Factory (an implementation of Abstract Factory)__ or it can let the system use the __Default Concrete Factory__

# "Factory" Demystified
We have been lying in the world of development with closely associated terms around "Factory". We all have heard __Static Factory__, __Factory method__ and now __Factory__.
As a matter of fact all three are different with a subtle difference.

* A _static factory_ is associated with a class only and can instance instances of only that class. The basic use of static factory is if there are several constructors with different set of parameters. To avoid confusions static factory provide a way around to name constructors and said in __Effective Java__ in the very first article.

* A _factory method_ is _non-static_ method that returns a base class or interface type that is implemented in hierarchy to leverage the strength of polymorphism. The subclasess implements the factory on its own way and thus both the classes and subclasses stands as factories.

* An _abstract Factory_ is an "interface for creating families of related objects without specifying the concrete class"