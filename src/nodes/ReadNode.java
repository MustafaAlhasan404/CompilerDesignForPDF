package nodes;

import java.util.Scanner;

public class ReadNode extends TreeNode {

	@Override
	public Object execute() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		return input;
	}

}
