package ch.unine.CMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MachineBean {
	@Id
	Long id;
	Long machineKindId;
	String IP;
	
	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public Long getMachineKindId() {
		return machineKindId;
	}

	public void setMachineKindId(Long machineKindId) {
		this.machineKindId = machineKindId;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
