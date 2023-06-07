package nodes;

import java.util.ArrayList;

public class ArrayNode extends TreeNode {

	@Override
	public Object execute() {
		System.out.println("Executing Special node");
		VariableType valueType = null;
		String arrayType;
		int arraySize = 0;
		String specialName;
		boolean isSpecial;

		arrayType = (String) this.children.get(0).execute();
		try {
			arraySize = (Integer) this.children.get(1).execute();
		} catch (Exception e) {
			System.err.println("Error: Array size must be an Integer value !!");
			System.exit(-1);
		}
		specialName = (String) this.children.get(2).execute();
		isSpecial = Boolean.valueOf((String) this.children.get(3).execute());

		if (arrayType.equals("String")) {
			ArrayList<Object> array = new ArrayList<>();
			if (isSpecial) {
				String arrayValue = (String) this.children.get(4).execute();
				for (int i = 0; i < arraySize; i++) {
					array.add(arrayValue);
				}
			} else {
				for (int i = 4; i < this.children.size(); i++) {
					String arrayValue = (String) this.children.get(i).execute();
					array.add(arrayValue);
				}
			}
			valueType = new VariableType(arrayType, arraySize, array);
		} else if (arrayType.equals("Integer")) {
			ArrayList<Object> array = new ArrayList<>();
			if (isSpecial) {
				int arrayValue = 0;
				try {
					arrayValue = (Integer) this.children.get(4).execute();
				} catch (Exception e) {
					System.err.println("Error: Array of Integer type can only contain Integer values !!");
					System.exit(-1);
				}
				for (int i = 0; i < arraySize; i++) {
					array.add(arrayValue);
				}
			} else {
				for (int i = 4; i < this.children.size(); i++) {
					try {
						int arrayValue = (Integer) this.children.get(i).execute();
						array.add(arrayValue);
					} catch (Exception e) {
						System.err.println("Error: Array of Integer type can only contain Integer values !!");
						System.exit(-1);
					}
				}
			}
			valueType = new VariableType(arrayType, arraySize, array);
		}

		AssignNode.variables.put(specialName, valueType);

		return null;
	}

}
