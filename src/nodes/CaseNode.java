package nodes;

public class CaseNode extends TreeNode {

	@Override
	public Object execute() {
		System.out.println("Executing Cases node");
		String str = (String) children.get(0).execute();
		if (AssignNode.variables.containsKey(str)) {
			VariableType var = AssignNode.variables.get(str);
			
			for (int i = 1; i < children.size(); i += 2) {
				Object t2 = (Object) children.get(i).execute();
				if (i == children.size() - 2 && t2.equals("[]:")) {
					children.get(i + 1).execute();
					i = children.size();
				}
				if (var.value.equals(t2)) {

					children.get(i + 1).execute();

					i = children.size();
				}

			}

		}
		return null;
	}

}
