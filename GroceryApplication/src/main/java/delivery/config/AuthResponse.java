package delivery.config;

public class AuthResponse {
	private String email;
	private String accessToken;
	private long contactNumber;

	public AuthResponse() { }
	
	public AuthResponse( long contactNumber,String accessToken) {
		//this.email = email;
		this.contactNumber=contactNumber;
		this.accessToken = accessToken;
	}
	
	

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

//	public String getEmail() {
//		return email;
//	}

//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
