package delivery.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import delivery.dto.DeliveryAgentDTO;
import delivery.dto.DeliveryManagerDTO;
import delivery.model.Role;
import delivery.model.User;
import delivery.services.DeliveryService;
import delivery.services.UserService;

@RestController
@RequestMapping("/admin")
public class AdminAPI {
	
	@Autowired private UserService service;
	@Autowired private DeliveryService deliveryService;

	//@RolesAllowed("ROLE_ADMIN")
	@RequestMapping(value = "/Register/deliveryManager", method = RequestMethod.POST)
	public ResponseEntity<?> saveDeliveryManager(@RequestBody DeliveryManagerDTO user) throws Exception {
		user.addRole(new Role(4));
		return ResponseEntity.ok(service.save(user));
	}
	
	
	//@RolesAllowed("ROLE_ADMIN")
	@RequestMapping(value = "/Register/deliveryAgent", method = RequestMethod.POST)
	public ResponseEntity<?> saveDeliveryAgent(@RequestBody DeliveryAgentDTO user) throws Exception {
		user.addRole(new Role(5));
		return ResponseEntity.ok(service.save(user));
	}
	
	//@RolesAllowed("ROLE_DELIVERYMANAGER")
	@GetMapping("/listOfDeliveryAgent/{DeliveryManagerId}")
	public ResponseEntity<?> listOfDeliveryAgent(@PathVariable long DeliveryManagerId){
		User user = service.findById(DeliveryManagerId);
		return ResponseEntity.ok(deliveryService.listOfAgents(user.getEmail()));
	}
	
	//@RolesAllowed("ROLE_DELIVERYAGENT")
	@PostMapping("/updateStatus/{orderId}/{status}")
	public ResponseEntity<?> updateOrderStatus(@PathVariable long orderId,@PathVariable String status){
		return ResponseEntity.ok(deliveryService.updateOrderStatus(orderId, status));
	}
	
	//@RolesAllowed("ROLE_DELIVERYAGENT")
	@GetMapping("/allAreaOrders/{deliveryAgentId}")
	public ResponseEntity<?> getAllOrder(@PathVariable long deliveryAgentId){
		return ResponseEntity.ok(deliveryService.areaOrders(deliveryAgentId));
	}
	
	
	
}
