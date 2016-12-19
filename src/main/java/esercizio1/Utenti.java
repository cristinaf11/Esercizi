package esercizio1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="utenti")
public class Utenti implements java.io.Serializable {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)//chiave primaria.Non serve esplicitare costruttore ma solo getter e setter
	private long user_id;
	
	private String userName;	
	
	
	private String userPassword;  // secondo campo
	
	
	
	
	

	public Utenti() {
	}

	
	public Utenti(String userName) {
		this.userName = userName;
	}

	public long getUserId() {
		return this.user_id;
	}

	public void setUserId(long user_id) {
		this.user_id = user_id;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
		 	public String toString() { 
			return "Utente [id=" + user_id + ", username=" + userName + ", password=" + userPassword + "]"; 
		} 
	 

}



