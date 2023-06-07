package nodes;

public class BlockNode extends TreeNode{

	
	/*
	 * The BlockNode's execute() function loops over all the children nodes and executes them.
	 * We can use add all types of nodes like if, for, assignment, modification, etc.
	 */
	@Override
	public Object execute() {
		System.out.println("Executing block node");
		for (TreeNode child : this.children) {
			child.execute();
		}
		return null;
	}
	
}
