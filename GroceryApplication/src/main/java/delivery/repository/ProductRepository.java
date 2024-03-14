package delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delivery.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findById(long id);
}
