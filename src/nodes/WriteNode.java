package nodes;

public class WriteNode extends TreeNode {

	@Override
	public Object execute() {
		System.out.println("Executing Write node");
		String isVar;
		String result = "";
		for (int i = 0; i < this.children.size(); i += 2) {
			isVar = (String) this.children.get(i).execute(); 	// isVar boolean variable is stored in odd indexs of array 
			if (isVar.equals("true")) {
				String varName = (String) this.children.get(i + 1).execute();
				if (AssignNode.variables.containsKey(varName)) {
					VariableType variable = AssignNode.variables.get(varName);
					if (variable.value != null) {
						result += variable.value;						
					}
					else {
						result += variable.array;												
					}
				}
			} else {
				String preResult = (String) this.children.get(i + 1).execute();
				result += preResult.substring(1, preResult.length() - 1);
			}
		}
		System.out.println(result);
		return null;
	}
}
