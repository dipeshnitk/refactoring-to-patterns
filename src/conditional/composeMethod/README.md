# What is a composed method?
A composed method consists of calls to other methods.

# What is the motivation behind it?

1. If you can't easily understand a method's logic then it needs to be transformed to compose method.
2. Good composed methods have code at the same level of detail.

E.g.
```java
private void paintCard(Graphics g) {
	Image image = null;
	if (card.getType().equals("Problem")) {
		image = explanations.getGameUI().problem;
	} else if (card.getType().equals("Solution")) {
		image = explanations.getGameUI().solution;
	} else if (card.getType().equals("Value")) {
		image = explanations.getGameUI().value;
}
   
g.drawImage(image,0,0,explanations.getGameUI());
   if (shouldHighlight())
     paintCardHighlight(g);
   paintCardText(g);
}
```
The code in bold is not at the same line of detail as the non-bold code.

The correct level of code would be:

```
private void paintCard(Graphics g) {
   paintCardImage(g);
   if (shouldHighlight())
     paintCardHighlight(g);
   paintCardText(g);
}
```
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