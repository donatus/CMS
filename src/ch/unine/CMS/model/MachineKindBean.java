package ch.unine.CMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MachineKindBean {
			@Id
			protected Long id;
			protected String name;
			protected String description;
			
			protected Long getId() {
				return id;
			}
			protected void setId(Long id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			
}
