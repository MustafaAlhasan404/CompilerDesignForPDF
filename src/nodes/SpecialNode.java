package nodes;

import java.util.ArrayList;

public class SpecialNode extends TreeNode {

	@Override
	public Object execute() {
		System.out.println("Executing Special node.");
		VariableType valueType = null;
		String specialType;
		int specialSize = 0;
		String specialName;
		boolean isArray;
		
		specialType = (String) this.children.get(0).execute();
		try {
			specialSize = (Integer)this.children.get(1).execute();			
		} catch (Exception e) {
			System.err.println("Error: Array size must be an Integer value !!");
			System.exit(-1);
		}
		specialName = (String) this.children.get(2).execute();
		isArray = Boolean.valueOf((String)this.children.get(3).execute());
		
		if(specialType.equals("String")) {
			if (!isArray) {
				String specialValue = (String) this.children.get(4).execute();
				String result = specialValue.substring(1, specialValue.length() - 1);
				for (int i = 0; i < specialSize; i++) {
					result += result;
				}
				result = "\"" + result + "\"";
				valueType = new VariableType(specialType, result);
			} else {
				ArrayList<Object> array = new ArrayList<>();
				for (int i = 4; i < this.children.size(); i++) {
					String specialValue = (String) this.children.get(i).execute();
					array.add(specialValue);
				}
				valueType = new VariableType(specialType, specialSize, array);
			}
		} else if(specialType.equals("Integer")) {
			if (!isArray) {
				System.err.println("Error: Special type can't be of type Interger !!");
				System.exit(-1);
			} else {
				ArrayList<Object> array = new ArrayList<>();
				for (int i = 4; i < this.children.size(); i++) {
					try {
						int specialValue = (Integer) this.children.get(i).execute();						
						array.add(specialValue);
					} catch (Exception e) {
						System.err.println("Error: Array of Integer type can only contain Integer values !!");
						System.exit(-1);
					}
				}
				valueType = new VariableType(specialType, specialSize, array);
			}
		}
		
		AssignNode.variables.put(specialName, valueType);
		
		return null;
	}

}
