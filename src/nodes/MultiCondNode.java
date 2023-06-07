package nodes;

public class MultiCondNode extends TreeNode {

	@Override
	public Object execute() {
		System.out.println("Executing multi-condition node");
		String op = "";
		boolean result = (Boolean) this.children.get(0).execute();
		for (int i = 1; i < this.children.size(); i++) {
			if (i % 2 != 0) {
				op = (String) this.children.get(i).execute();
				continue;
			}
			if (op.equals("and")) {
				result &= (Boolean) this.children.get(i).execute();
			} else if (op.equals("or")) {
				result |= (Boolean) this.children.get(i).execute();
			}
		}
		return result;
	}

}
