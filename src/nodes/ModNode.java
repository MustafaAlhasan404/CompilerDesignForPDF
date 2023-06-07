package nodes;

public class ModNode extends TreeNode {

	@Override
	public Object execute() {
		System.out.println("Executing Mod node");

		// Firstly, we need to check if the variable exists in the variables HashMap in
		// AssignNode.

		// Get variable name
		String varName = (String) children.get(0).execute();
		String newValue;

		// Search the Hashmap for the variable if it exists.
		if (AssignNode.variables.containsKey(varName)) {
			// If it exists, get the value and type of the variable using the varName.
			VariableType var = AssignNode.variables.get(varName);

			String isOP = (String) children.get(3).execute();
			if (isOP.equals("true")) {
				if (var.value instanceof Integer) {
					int varValue = (Integer) var.value;
					isOP = (String) children.get(1).execute();
					if (isOP.equals("++")) {
						varValue++;
					} else {
						varValue--;
					}
					var.value = varValue;
				} else {
					System.err.println("Error: Increment and Decrement operations are not possible on Strings !!");
					System.exit(-1);
				}
			} else {
				// Check if the 2nd operand is a variable
				String isVar = (String) children.get(2).execute();
				// Get the new value from the second child.
				newValue = (String) children.get(1).execute();
				if (isVar.equals("true")) {
					if (AssignNode.variables.containsKey(newValue)) {
						VariableType inputVar = AssignNode.variables.get(newValue);
						if (inputVar.value instanceof Integer) {
							newValue = String.valueOf(inputVar.value);
						} else {
							newValue = (String) inputVar.value;
						}
					} else {
						System.err.println("Error: " + newValue + " is not declared !!");
						System.exit(-1);
					}
				}
				// Set the new value instead of the old value.
				var.value = newValue;
			}

			// Put back the new value and type into the hashmap
			AssignNode.variables.put(varName, var);

			System.out.println("Mod node variables is: " + AssignNode.variables);

		} else {
			// if it doesn't exist, print an error.
			System.err.println("Error: Undefiend Variable " + varName + " !!");
			System.exit(-1);
		}

		return null;
	}
}
