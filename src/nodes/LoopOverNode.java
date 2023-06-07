package nodes;

public class LoopOverNode extends TreeNode {

	@Override
	public Object execute() {

		String name = (String) this.children.get(0).execute();
		if (AssignNode.variables.containsKey(name)) {
			VariableType var = AssignNode.variables.get(name);
			if (var.array != null) {

				if (this.children.size() <= 2) {
					VariableType it = null;
					for (Object iter : var.array) {
						if (iter instanceof String) {
							it = new VariableType("String", iter);
						} else {
							it = new VariableType("Integer", iter);
						}
						AssignNode.variables.put("iter", it);
						this.children.get(1).execute();
					}
					AssignNode.variables.remove(name);
				} else {
					String name2 = (String) this.children.get(1).execute();
					VariableType it = null;
					for (Object iter : var.array) {
						if (iter instanceof String) {
							it = new VariableType("String", iter);
						} else {
							it = new VariableType("Integer", iter);
						}
						AssignNode.variables.put(name2, it);
						this.children.get(1).execute();
					}
					AssignNode.variables.remove(name2);
				}
			}
		}

		return null;
	}

}
