package ch.unine.CMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class UserBean {
		protected Long id;
		protected String login;
		protected String passwd;
		protected String contact;
		
		protected Long getId() {
			return id;
		}
		protected void setId(Long id) {
			this.id = id;
		}
		protected String getLogin() {
			return login;
		}
		protected void setLogin(String login) {
			this.login = login;
		}
		public String getPasswd() {
			return passwd;
		}
		protected void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		protected String getContact() {
			return contact;
		}
		protected void setContact(String contact) {
			this.contact = contact;
		}
		
}
