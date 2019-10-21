package kata.supermarket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kata.supermarket.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product findByName(String name);
}
