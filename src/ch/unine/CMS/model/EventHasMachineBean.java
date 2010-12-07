package ch.unine.CMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventHasMachineBean {
	@Id
	protected int t_events_id;
	protected int t_machines_id;
	protected int id;
	
	protected int getT_events_id() {
		return t_events_id;
	}
	protected void setT_events_id(int t_events_id) {
		this.t_events_id = t_events_id;
	}
	protected int getT_machines_id() {
		return t_machines_id;
	}
	protected void setT_machines_id(int t_machines_id) {
		this.t_machines_id = t_machines_id;
	}
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	
}
