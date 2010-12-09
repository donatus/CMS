package ch.unine.CMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventHasMachineBean {
	@Id
	protected Long eventId;
	protected Long machineId;
	protected Long id;
	
	protected Long getEventId() {
		return eventId;
	}
	protected void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	protected Long getMachineId() {
		return machineId;
	}
	protected void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	
}
