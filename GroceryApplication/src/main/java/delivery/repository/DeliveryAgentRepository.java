package delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import delivery.model.DeliveryAgent;


public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Integer>  {

	DeliveryAgent findByEmail(String email);
}
