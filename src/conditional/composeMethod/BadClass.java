package conditional.composeMethod;

public class BadClass {
	// Do not bother on the value
	private boolean readOnly = false;
	// Do not bother on the value
	private int size;
	// Do not bother on the value
	private Object[] elements = new Object[Integer.MAX_VALUE];

	// Bad method with code smell
	public void add(Object element) {
		if (!readOnly) {
			int newSize = size + 1;
			if (newSize > elements.length) {
				Object[] newElements = new Object[elements.length + 10];
				for (int i = 0; i < size; i++)
					newElements[i] = elements[i];
				elements = newElements;
			}
			elements[size++] = element;
		}
	}
}
