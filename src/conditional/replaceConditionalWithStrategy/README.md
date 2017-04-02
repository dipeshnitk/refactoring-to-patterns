# What is the motivation behind it?

1. Conditional logic tends to grow more and more complex over time and hence complicate the code more.
2. Conditional logic decides which of the various algorithms will be executed. By algorithm, we not only mean complex logic around an object. An algorithm can be as easy as a simple calculation.
3. Compose method if applied to a long conditional chain may litter the code with numerous small methods. It may be beneficial in that case, to move the methods to _subclasses of the host_ or to _completely new classes_.
This needs to decide between __composition__ and __inheritence__

# Description on Strategy pattern to replace conditional statements

* _Replace Conditional With Strategy_ involves object composition. For each algorithm we create a separate class and outfit the host class with the correct class (denoting a strategy).

* _Replace Conditional with Polymorphism_ as described by Martin Fowler in his book __Refactoring: Improving the Design of Existing Code__ uses inheritance based approach.

# How to decide if to use Polymorphism or Strategy.

* If the conditionals in the algorithm are controlled by one type code, it may be easy to create subclasses of the algorithm's host class, one for each type code (_see Replace Type Code with Subclasses in Martin Fowler's book_). If there is no such type code, you'll likely be better off refactoring to Strategy. 

* If clients need to swap one calculation type for another at runtime, you'd better avoid an inheritance-based approach because this means changing the type of object a client is working with rather than simply substituting one Strategy instance for another.

# How to pass the values required to implement the strategy from host class to strategy?

When deciding whether to refactor to or towards a Strategy, you have to consider how the algorithm embedded in each Strategy will access the data it needs to do its job. There are two ways to do this: 
* pass the host class (_called the context_) to the Strategy so it can call back on methods to get its data,
* just pass the data directly to the Strategy via parameters.

# How to decide on the strategy?
Most of the time client is given the responsibility to decide the strategy as the host class holds the strategy instance. Then you might question what is the advantage of strategy?
The answer is that if you are required to implement yet another algorithm, then you could just sublcass the strategy and implement the algorithm. The host class is already holding a Abstract Strategy reference and so can be relaced easily.

# What if the strategies are not to be decided by the client?
Hold a list of all the strategies and pass the reference object to all the strategies. The strategies has a method to check if it needs to operate on the values or not.
Once a strategy returns true if,the loop is broken.