package nodes;

public class AsLongNode extends TreeNode {

	@Override
	public Object execute() {
		
		while ((Boolean) this.children.get(0).execute()) {
			this.children.get(1).execute();
		}
		
		return null;
	}

}
