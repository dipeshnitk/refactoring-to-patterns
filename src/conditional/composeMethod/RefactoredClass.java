package conditional.composeMethod;

public class RefactoredClass {
	// Do not bother on the value
	private boolean readOnly = false;
	// Do not bother on the value
	private int size;
	// Do not bother on the value
	private Object[] elements = new Object[Integer.MAX_VALUE];
	
	private static final int GROWTH_CAPACITY=10;

	// Refactored method with Compose method
	public void add(Object element) {
		if (readOnly)
			return; // Easy return brings the code at same level
		if(atCapacity())
			grow(); // Extracted method makes it more clear
		addElement(element);
	}

	private void addElement(Object element) {
		elements[size++] = element;
	}

	private void grow() {
		Object[] newElements = new Object[elements.length + GROWTH_CAPACITY];//Magic number should not be used
		for (int i = 0; i < size; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	private boolean atCapacity() {
		return (size + 1)>elements.length;
	}

}
