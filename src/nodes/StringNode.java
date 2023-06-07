package nodes;

public class StringNode extends TreeNode {

	String value;
	
	public StringNode(String val) {
		this.value = val;
	}
	
	@Override
	public Object execute() {
		System.out.println("Executing String node");
		return this.value;
	}

}
