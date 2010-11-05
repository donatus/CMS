package ch.unine.CMS.model;

import java.sql.Date;

public class EventBean {
		protected int id;
		protected Date start_time;
		protected Date end_time;
		protected String name;
		protected String description;
		protected int user_id;
		protected int t_users_id;
		
		protected int getId() {
			return id;
		}
		protected void setId(int id) {
			this.id = id;
		}
		protected Date getStart_time() {
			return start_time;
		}
		protected void setStart_time(Date start_time) {
			this.start_time = start_time;
		}
		protected Date getEnd_time() {
			return end_time;
		}
		protected void setEnd_time(Date end_time) {
			this.end_time = end_time;
		}
		protected String getName() {
			return name;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected String getDescription() {
			return description;
		}
		protected void setDescription(String description) {
			this.description = description;
		}
		protected int getUser_id() {
			return user_id;
		}
		protected void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		protected int getT_users_id() {
			return t_users_id;
		}
		protected void setT_users_id(int t_users_id) {
			this.t_users_id = t_users_id;
		}
		
}
