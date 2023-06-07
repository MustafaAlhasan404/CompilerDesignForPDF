package nodes;

public class IterateNode extends TreeNode {

	@Override
	public Object execute() {
		String iterator = (String) this.children.get(0).execute();
		int from = (Integer) this.children.get(1).execute();
		int to = (Integer) this.children.get(2).execute(); 
		
		VariableType var = new VariableType("Integer", from);
		AssignNode.variables.put(iterator, var);

		for (int i = from; i <= to; i++) {
			this.children.get(3).execute();
			var.setValue(++from);
			AssignNode.variables.put(iterator, var);
		}
		AssignNode.variables.remove(iterator);
		return null;
	}

}
