package delivery.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delivery.model.DeliveryAgent;
import delivery.model.DeliveryManager;
import delivery.model.Orders;
import delivery.model.User;
import delivery.repository.DeliveryAgentRepository;
import delivery.repository.DeliveryManagerRepository;
import delivery.repository.OrderRepository;
import delivery.repository.UserRepository;

@Service
@Transactional
public class DeliveryService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private DeliveryAgentRepository agentRepo;
	@Autowired
	private DeliveryManagerRepository managerRepo;
	@Autowired 
	private OrderRepository orderRepo;
	
	public List<Orders> areaOrders(long id){
		List<Orders> allOrders = orderRepo.findAll();
		List<Orders> allocatedOrders = new ArrayList<>();
		User user = repo.findById(id);
		DeliveryAgent agent = agentRepo.findByEmail(user.getEmail());
		
		for(Orders order : allOrders) {
			if(agent.getAllocatedApartment().equalsIgnoreCase(order.getUser().getUserAddress().getApartment())) {
				allocatedOrders.add(order);
			}
		}
		return allocatedOrders;
	}
	
	public String updateOrderStatus(long id , String status) {
		Orders order = orderRepo.findById(id);
		order.setStatus(status);
		return "Order Status updated";
		
	}

	public List<DeliveryAgent> listOfAgents(String email) {
		// TODO Auto-generated method stub
		DeliveryManager manager  = managerRepo.findByEmail(email);
		List<DeliveryAgent> allAgents = agentRepo.findAll(); 
		List<DeliveryAgent> myAreaAgents = new ArrayList<>();
		for(DeliveryAgent agent : allAgents) {
			if(agent.getLocation().equalsIgnoreCase(manager.getAllocatedLocation())) {
				myAreaAgents.add(agent);
			}
		}
		return myAreaAgents;
	}
	
	
	
	
	
}
