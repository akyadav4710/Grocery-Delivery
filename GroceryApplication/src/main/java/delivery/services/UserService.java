package delivery.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import delivery.model.CartItem;
import delivery.model.DeliveryAgent;
import delivery.model.DeliveryManager;
import delivery.model.OrderItem;
import delivery.model.Orders;
import delivery.model.Role;
import delivery.model.User;
import delivery.dto.DeliveryAgentDTO;
import delivery.dto.DeliveryManagerDTO;
import delivery.dto.UserDTO;
import delivery.repository.DeliveryAgentRepository;
import delivery.repository.DeliveryManagerRepository;
import delivery.repository.RoleRepository;
import delivery.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private DeliveryAgentRepository agentRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DeliveryManagerRepository managerRepo;
	@Autowired 
	private RoleRepository roleRepository;

	public UserDTO save(User user) {

		if (user.getRoles().isEmpty()) {
			user.addRole(new Role(3));
		}
		user.setUserAddress(user.getUserAddress());
		String rawPassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encodedPassword);
		repo.save(user);
		UserDTO newUser = new UserDTO();
		newUser.setId(user.getId());
		newUser.setEmail(user.getEmail());
		newUser.setFullName(user.getFullname());
		newUser.setUserAddress(user.getUserAddress());
		return newUser;
	}

	public String insertRoles() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleCustomer = new Role("ROLE_CUSTOMER");
        Role roleDeliveryAgent = new Role("ROLE_DELIVERYAGENT");
        Role roleDeliveryManager = new Role("ROLE_DELIVERYMANAGER");
        Role roleEditor = new Role("ROLE_EDITOR");

        // Save roles to the database
        roleRepository.save(roleAdmin);
        roleRepository.save(roleCustomer);
        roleRepository.save(roleDeliveryAgent);
        roleRepository.save(roleDeliveryManager);
        roleRepository.save(roleEditor);
        return "ROLES ADDED TO DATABASE";
    }
	
	public User findById(Long id) {
		return repo.findById(id);
	}

	public Object save(DeliveryManagerDTO managerDto) {
		User newUser = new User();
		
		String encodedPassword = passwordEncoder.encode(managerDto.getPassword());
		newUser.setPassword(encodedPassword);
		newUser.setRoles(managerDto.getRoles());
		newUser.setEmail(managerDto.getEmail());
		newUser.setUserAddress(managerDto.getUserAddress());
		newUser.setFullname(managerDto.getFullname());
		newUser.setContactNumber(managerDto.getContactNumber());
		repo.save(newUser);
		DeliveryManager newManager = new DeliveryManager();
		newManager.setAllocatedLocation(managerDto.getAllocatedLocation());
		newManager.setEmail(managerDto.getEmail());
		newManager.setFullName(managerDto.getFullname());
		newManager.setContactNumber(managerDto.getContactNumber());
		managerRepo.save(newManager);
		return newManager;
	}

	public Object save(DeliveryAgentDTO agentDto) {
		User newUser = new User();
		String encodedPassword = passwordEncoder.encode(agentDto.getPassword());
		newUser.setPassword(encodedPassword);
		newUser.setRoles(agentDto.getRoles());
		newUser.setEmail(agentDto.getEmail());
		newUser.setUserAddress(agentDto.getUserAddress());
		newUser.setFullname(agentDto.getFullname());
		newUser.setContactNumber(agentDto.getContactNumber());
		repo.save(newUser);
		DeliveryAgent newAgent = new DeliveryAgent();
		newAgent.setAllocatedApartment(agentDto.getAllocatedApartment());
		newAgent.setEmail(agentDto.getEmail());
		newAgent.setFullName(agentDto.getFullname());
		newAgent.setContactNumber1(agentDto.getContactNumber());
		newAgent.setGender(agentDto.getGender());
		newAgent.setLocation(agentDto.getLocation());
		newAgent.setSociety(agentDto.getSociety());
		agentRepo.save(newAgent);
		return newAgent;
	}

	public List<Orders> placeOrder(long id) {

		User user = repo.findById(id);
		if (user != null) {
			Orders order = new Orders();
			// Set other order details like date, total price, etc.
			// ...

			long totalPrice = 0;
			for (CartItem cartItem : user.getCartItems()) {
				OrderItem orderItem = new OrderItem();
				if (!cartItem.isRemoved()) {
					float price = cartItem.getProduct().getPrice();
					long quantity = cartItem.getQuantity();
					totalPrice += (price * quantity);
					order.setTotalPrice(totalPrice);
					orderItem.setProduct(cartItem.getProduct());
					orderItem.setQuantity(cartItem.getQuantity());
					order.addOrderItem(orderItem);
					order.setStatus("Order Placed");
					order.setOrderDate(new Date());
					cartItem.setRemoved(true);
				}
			}

			// Clear the user's cart
			user.getCartItems().clear();

			// Add the new order to the user
			if(!order.getOrderItems().isEmpty())
			user.addOrder(order);

			// Save the changes to the database
			repo.save(user);
		}

		return user.getOrders();
	}

}
