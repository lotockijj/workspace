package com.main.fx;

public class Inhouse extends Part {
	
	int machineId;
	
	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
	
	public String toString() {
		return "Part [name=" + name + ", partID=" + partID + ", price=" + price + ", instock=" + instock + ", min="
				+ min + ", max=" + max + ", Machine Id= " + machineId + "]";
	}
	
}
