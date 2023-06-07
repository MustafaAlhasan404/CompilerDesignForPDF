package nodes;

public class IfNode extends TreeNode {

	@Override
	public Object execute() {

		for (int i = 0; i < this.children.size(); i += 2) {
			if (this.children.get(i).execute() == null) {
				break;				
			} else if ((boolean) this.children.get(i).execute()) {
				this.children.get(i + 1).execute();
				break;
			}
		}
		return null;
	}
}
