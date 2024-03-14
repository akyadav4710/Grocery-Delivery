package delivery.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import delivery.model.UserAddress;

public class UserDTO {
	private long id;
	private String email;
	private String fullname;
	private UserAddress userAddress;

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	
	public String getFullName() {
		return fullname;
	}

	public void setFullName(String fullName) {
		this.fullname = fullName;
	}

	public UserDTO() {
	}

	public UserDTO(Integer id, String email) {
		this.id = id;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
