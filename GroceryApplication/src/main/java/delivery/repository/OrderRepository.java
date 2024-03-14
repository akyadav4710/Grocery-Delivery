package delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import delivery.model.DeliveryAgent;
import delivery.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>  {

	List<Orders> findAll();

	Orders findById(long id);
	
}
