package delivery.config;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AuthRequest {
	//@NotNull @Email @Length(min = 5, max = 50)
	//private String email;
	
	@NotNull @Length(min = 5, max = 10)
	private String password;
	
	@NotNull 
	private long contactNumber;

	public AuthRequest() {
		
	}
	
	
	
	public long getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}



	public AuthRequest(long contactNumber,String password) {
		//this.email = email;
		this.contactNumber=contactNumber;
		this.password = password;
	}

//	public String getEmail() {
//		return email;
//	}

//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
