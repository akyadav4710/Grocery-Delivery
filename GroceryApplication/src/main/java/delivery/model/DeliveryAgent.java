package delivery.model;

import javax.persistence.*;

@Entity
public class DeliveryAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fullname;
	private String Gender;
	private String email;
	private Long contactNumber1;
	private String allocatedApartment;
	private String society;
	private String location;
	
	
	
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSociety() {
		return society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNumber1() {
		return contactNumber1;
	}
	public void setContactNumber1(Long contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}
	public String getAllocatedApartment() {
		return allocatedApartment;
	}
	public void setAllocatedApartment(String allocatedApartment) {
		this.allocatedApartment = allocatedApartment;
	}
	public DeliveryAgent() {
		super();
		
	}
	
	
	
	
}
