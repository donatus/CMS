package ch.unine.CMS.model;

public class MachineBean {
	int id;
	int machineKindId;
	String IP;
	
	protected String getIP() {
		return IP;
	}

	protected void setIP(String iP) {
		IP = iP;
	}

	protected int getMachineKindId() {
		return machineKindId;
	}

	protected void setMachineKindId(int machineKindId) {
		this.machineKindId = machineKindId;
	}

	
	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	
}
