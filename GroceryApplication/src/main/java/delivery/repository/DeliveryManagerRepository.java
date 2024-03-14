package delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import delivery.model.DeliveryManager;



public interface DeliveryManagerRepository extends JpaRepository<DeliveryManager, Integer> {

	DeliveryManager findByEmail(String email);

	DeliveryManager findById(long deliveryManagerId);
	
}
