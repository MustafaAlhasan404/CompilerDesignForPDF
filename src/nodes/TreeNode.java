package nodes;

import java.util.ArrayList;

public abstract class TreeNode {

	public ArrayList<TreeNode> children = new ArrayList<TreeNode>();

	public void addChild(TreeNode node) {
		children.add(node);
	}

	public abstract Object execute();
}
