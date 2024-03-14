package delivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeliveryManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fullname;
	private String email;
	private long contactNumber;
	private String AllocatedLocation;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullname;
	}
	public void setFullName(String fullName) {
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
	public DeliveryManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
