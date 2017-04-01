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
The code in the first few lines if-else statements are not at the same level to the last three lines of code.

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

Apply extract method rule until you have refactored the method in question to small private methods.

Once you have done that, you might well as try to enable Extract Class by grouping the same methods to a different class that seems not to be a part of the top class.

# Video Attached in the same location for reference
