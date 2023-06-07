package nodes;

public class ConditionNode extends TreeNode {

	@Override
	public Object execute() {
		System.out.println("Executing condition node");
		Object operand1 = null;
		Object operand2 = null;
		String operation = (String) this.children.get(2).execute();
		
		if (this.children.get(0) instanceof StringNode) {
			String var = (String) this.children.get(0).execute();
			if (AssignNode.variables.containsKey(var)) {
				VariableType variable = AssignNode.variables.get(var);
				if (variable.value instanceof Integer) {
					operand1 = (Integer) variable.value;
				} else {
					operand1 = String.valueOf(variable.value);
				}
			} else {
				// if it doesn't exist, print an error.
				System.err.println("Error: Undefiend Variable " + var + " !!");
				System.exit(-1);
			}
		} else {
			operand1 = (Integer) this.children.get(0).execute();
		}
		
		if (this.children.get(1) instanceof StringNode) {
			String var = (String) this.children.get(1).execute();
			if (AssignNode.variables.containsKey(var)) {
				VariableType variable = AssignNode.variables.get(var);
				if (variable.value instanceof Integer) {
					operand2 = (Integer) variable.value;
				} else {
					operand2 = String.valueOf(variable.value);
				}
			} else {
				// if it doesn't exist, print an error.
				System.err.println("Error: Undefiend Variable " + var + " !!");
				System.exit(-1);
			}
		} else {
			operand2 = (Integer) this.children.get(1).execute();
		} 
		
		if (operand1 instanceof String && operand2 instanceof String) {
			String oper1 = (String) operand1;
			String oper2 = (String) operand2;
			if (operation.equals("!=")) {
				return oper1.compareTo(oper2) != 0;
			} else if (operation.equals("<")) {
				return oper1.compareTo(oper2) < 0;
			} else if (operation.equals(">")) {
				return oper1.compareTo(oper2) > 0;
			} else {
				return oper1.compareTo(oper2) == 0;
			}
			
		} else if (operand1 instanceof Integer && operand2 instanceof Integer) {
			Integer oper1 = (Integer) operand1;
			Integer oper2 = (Integer) operand2;
			if (operation.equals("!=")) {
				return oper1.compareTo(oper2) != 0;
			} else if (operation.equals("<")) {
				return oper1 < oper2;
			} else if (operation.equals(">")) {
				return oper1 > oper2;
			} else {
				return oper1.compareTo(oper2) == 0;
			}
		} else {
			System.err.println("Error: Comparing two operands with different types is not possible !! ");
			System.exit(-1);
			return false;
		}
	}
}
