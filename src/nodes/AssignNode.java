package nodes;

import java.util.HashMap;

public class AssignNode extends TreeNode {

	/*
	 * The variables HashMap stores all variables that are declared with their type
	 * and values. The type and value are stored inside the VariableType class. It
	 * is static because we want the value to be consistent across the entire
	 * program and all instances and to be able to use it from anywhere.
	 */
	public static HashMap<String, VariableType> variables = new HashMap<String, VariableType>();

	@Override
	public Object execute() {
		System.out.println("Executing Assign node.");
		VariableType valueType;
		String varType;
		String varName;
		String varValue;
		if (children.size() == 4) {
			// Get type, name and value from the three child nodes.
			varType = (String) children.get(0).execute();
			varName = (String) children.get(1).execute();
			varValue = (String) children.get(2).execute();
			String isVar = (String) children.get(3).execute();
			if (isVar.equals("true")) {
				if (AssignNode.variables.containsKey(varValue)) {
					VariableType inputVar = AssignNode.variables.get(varValue);
					if (inputVar.value instanceof Integer) {
						varValue = String.valueOf(inputVar.value);
					} else {
						varValue = (String) inputVar.value;
					}
				} else {
					System.err.println("Error: " + varValue + " is not declared !!");
					System.exit(-1);
				}
			}
			valueType = new VariableType(varType, varValue);
		} else {
			varType = (String) children.get(0).execute();
			varName = (String) children.get(1).execute();
			valueType = new VariableType(varType);
		}
		// Create new VariableType using the type and value

		// Add the new variable to the hashmap
		AssignNode.variables.put(varName, valueType);
		System.out.println("Assign node variables is: " + AssignNode.variables);

		return null;
	}

	static public Object getValue(String key) {
		if (variables.containsKey(key)) {
			return variables.get(key);
		} else {
			System.err.println("Error:" + key + " is not defined !!");
			System.exit(-1);
			return null;
		}
	}

}
