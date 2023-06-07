package nodes;

import java.util.ArrayList;

public class VariableType {

	public String type;
	public Object value;
	public ArrayList<Object> array;
	public int size = 0;
	
	public void setValue(int v) {
		this.value = v;
	}
	
	public VariableType(VariableType var) {
		this.type = var.type;
		this.value = var.value;
		this.array = new ArrayList<>(var.array);
	}
	
	public VariableType(String t, Object v) {
		this.type = t;
		this.value = v;
		this.array = null;
	}	

	public VariableType(String t) {
		this.type = t;
		this.value = null;
		this.array = null;
	}	

	public VariableType(String t, int s, ArrayList<Object> arr) {
		if (t.equals("Integer")) {
			this.type = t;
		} else if (t.equals("String")) {
			this.type = t;
		} else {
			System.err.println("Error: Only String and Integer types are supported !!");
			System.exit(-1);
		}
		this.array = new ArrayList<>();
		for (Object object : arr) {
			this.array.add(object);
		}
	}
	
	public VariableType(String t, int v) {
		this.type = t;
		this.value = v;
	}
	
	public VariableType(String t, String v) {
		this.array = null;
		if (t.equals("Integer")) {
			try {
				this.type = t;
				this.value = Integer.parseInt(v);
			} catch (Exception e) {
				System.err.println("Error: You are inserting a String to an Integer !!");
				System.exit(-1);
			}
		} else if (t.equals("String")) {
			this.type = t;
			this.value = v.substring(1, v.length() - 1);
		} else {
			System.err.println("Error: Only String and Integer types are supported !!");
			System.exit(-1);
		}
	}

	@Override
	public String toString() {
		if (value == null && array == null) {
			return "type: " + this.type + " , value: null";
		} else if (array == null) {
			return "type: " + this.type + " , value: " + this.value;
		} else {
			return "type: " + this.type + " , array: " + this.array;			
		}
	}
}
