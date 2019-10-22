package kata.supermarket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kata.supermarket.entity.Product;
import kata.supermarket.service.ProductService;
import kata.supermarket.service.ShoppingUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MarketApplication.class)
public class MarketApplicationTest {

	ShoppingUtil util = mock(ShoppingUtil.class);
	Product prod = mock(Product.class);
	ProductService productService = new ProductService();
	
	@Test
	public void test() {
		when(util.productList()).thenReturn(productList());	
		when(prod.getName()).thenReturn("Beans");
		assertThat(productService.findByNameAndCalculatePrice(prod.getName()).size(),is(6));
	}
	
	public List<Product> productList() {
		List<Product> listOfProducts = Arrays.asList(new Product(0.50, "Beans", 1), new Product(0.50, "Beans", 1),
				new Product(0.50, "Beans", 1), new Product(0.70, "coke", 1), new Product(0.70, "coke", 1),
				new Product(1.20, "Oranges", 5));
		return listOfProducts;

	}

}
