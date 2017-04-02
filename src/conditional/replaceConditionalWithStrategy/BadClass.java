package conditional.replaceConditionalWithStrategy;

/**
 * The below class represents the very bad design to calculate the different
 * types of loan in the capital method. Currently there are only three ways to
 * calculate the loan, but it could grow to others very soon and we could keep
 * adding if statements again and again. Thus this seems to be a possible class
 * of refactoring the conditional logic.
 * 
 * @author dipeshgupta
 *
 */
public class BadClass {
	// Dont bother on the values
	public double calculateInsurance(double income) {
		if (income <= 10000) {
			return income * 0.365;
		} else if (income <= 30000) {
			return (income - 10000) * 0.2 + 35600;
		} else if (income <= 60000) {
			return (income - 30000) * 0.1 + 76500;
		} else {
			return (income - 60000) * 0.02 + 105600;
		}

	}
}
