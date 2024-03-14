package delivery.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delivery.model.Product;
import delivery.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public Product findById(long id) {
		return productRepo.findById(id);
	}

}
