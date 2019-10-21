package kata.supermarket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kata.supermarket.entity.Product;
import kata.supermarket.service.ProductService;


@SpringBootApplication
public class MarketApplication implements CommandLineRunner{

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Product> products =productService.findByNameAndCalculatePrice("coke");
		for(Product product:products) {
			System.out.println(""+product.getName()+" "+product.getPrice());
		}
		
	}

	
}
