package nodes;

public class ConstNode extends TreeNode {

	String value;
	
	public ConstNode(String val) {
		this.value = val;
	}
	
	@Override
	public Object execute() {
		System.out.println("Executing Const node");
		Integer intValue = Integer.parseInt(value);
		return intValue;
	}

}
