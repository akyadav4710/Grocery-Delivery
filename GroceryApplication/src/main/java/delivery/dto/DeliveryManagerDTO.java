package delivery.dto;

import java.util.HashSet;
import java.util.Set;

import delivery.model.Role;
import delivery.model.UserAddress;

public class DeliveryManagerDTO {

	private long id;
	private String fullname;
	private String email;
	private long contactNumber;
	private String AllocatedLocation;
	private UserAddress userAddress;
	private String password;
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	
	private Set<Role> roles = new HashSet<>();
	
	public Set<Role> getRoles() {
		return roles;
	}

	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullName) {
		this.fullname = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getAllocatedLocation() {
		return AllocatedLocation;
	}
	public void setAllocatedLocation(String allocatedLocation) {
		AllocatedLocation = allocatedLocation;
	}
	
	

	
}
