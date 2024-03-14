package delivery.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import delivery.model.CartItem;
import delivery.model.Product;
import delivery.model.Role;
import delivery.model.User;
import delivery.dto.UserDTO;
import delivery.services.ProductService;
import delivery.services.UserService;

@RestController
public class UserApi {

	@Autowired private UserService userService;
	@Autowired private ProductService productService;
	
	/*
	 * @PutMapping("/register") public ResponseEntity<?>
	 * createUser(@RequestBody @Valid User user) { User createdUser =
	 * service.save(user); URI uri = URI.create("/users/" + createdUser.getId());
	 * 
	 * UserDTO userDto = new UserDTO(createdUser.getId(), createdUser.getEmail());
	 * 
	 * return ResponseEntity.created(uri).body(userDto); }
	 */
	
	
	@PostMapping("/addRoles")
	public ResponseEntity<?> addRoles(){
		return ResponseEntity.ok(userService.insertRoles());
	}
	
	 @PostMapping("/add")
	    public ResponseEntity<String> addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam long quantity) {
	        User user = userService.findById(userId);
	        Product product = productService.findById(productId);

	        if (user != null && product != null) {
	            CartItem cartItem = new CartItem();
	            cartItem.setUser(user);
	            cartItem.setProduct(product);
	            cartItem.setQuantity(quantity);
	            user.addToCart(cartItem);
	            userService.save(user);
	            return ResponseEntity.ok("Product added to cart.");
	        } else {
	            return ResponseEntity.badRequest().body("Invalid user or product.");
	        }
	    }

	    @PostMapping("/remove")
	    public ResponseEntity<String> removeFromCart(@RequestParam Long userId, @RequestParam Long cartItemId) {
	        User user = userService.findById(userId);

	        if (user != null) {
	            CartItem cartItemToRemove = user.getCartItems().stream()
	                    .filter(item -> item.getId().equals(cartItemId))
	                    .findFirst()
	                    .orElse(null);

	            if (cartItemToRemove != null) {
	                user.removeFromCart(cartItemToRemove);
	                userService.save(user);
	                return ResponseEntity.ok("Product removed from cart.");
	            }
	           
	        }
	        return ResponseEntity.badRequest().body("Invalid user or cart item.");
	    }

   
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userService.save(user));
	}
	
	
	@GetMapping("/findUser/{id}")
	public ResponseEntity<?> findUser(@PathVariable Long id){
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@PostMapping("/placeOrder/{id}")
	public ResponseEntity<?> placeMyOrder(@PathVariable long id){
		return ResponseEntity.ok(userService.placeOrder(id));
	}
	
	@GetMapping("/getMyOrders/{id}")
	public ResponseEntity<?> getOrders(@PathVariable long id){
		User newUser =  userService.findById(id);
		return ResponseEntity.ok(newUser.getOrders());
	}
	
	
}
