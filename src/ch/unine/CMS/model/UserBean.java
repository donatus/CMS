package ch.unine.CMS.model;

public class UserBean {
		protected int id;
		protected String login;
		protected String passwd;
		protected String contact;
		protected int getId() {
			return id;
		}
		protected void setId(int id) {
			this.id = id;
		}
		protected String getLogin() {
			return login;
		}
		protected void setLogin(String login) {
			this.login = login;
		}
		protected String getPasswd() {
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
