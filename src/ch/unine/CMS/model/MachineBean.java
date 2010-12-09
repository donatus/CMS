package ch.unine.CMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MachineBean {
	@Id
	Long id;
	Long machineKindId;
	String IP;
	
	protected String getIP() {
		return IP;
	}

	protected void setIP(String iP) {
		IP = iP;
	}

	protected Long getMachineKindId() {
		return machineKindId;
	}

	protected void setMachineKindId(Long machineKindId) {
		this.machineKindId = machineKindId;
	}

	
	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	
}
