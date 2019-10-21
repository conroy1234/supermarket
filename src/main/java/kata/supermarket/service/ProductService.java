package kata.supermarket.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kata.supermarket.entity.Product;
import kata.supermarket.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	double totalcost;

	private double discountPercentage = 0.0;

	public List<Product> productList() {
		List<Product> listOfProducts = Arrays.asList(new Product(0.50, "Beans", 1), new Product(0.50, "Beans", 1),
				new Product(0.50, "Beans", 1), new Product(0.70, "coke", 1), new Product(0.70, "coke", 1),
				new Product(1.20, "Oranges", 5));
		return listOfProducts;

	}

	public List<Product> findByNameAndCalculatePrice(String name) {
		List<Product> products = productList();
		for (Product item : products) {

			// Product item = productRepository.findByName(name);

			if (item.getQuantity() >= 2 && item.getName().equals("Beans")) {
				this.discountPercentage = discountPersentage(item.getQuantity(), this.totalcost);

			}else
			if (item.getQuantity() >= 2 && item.getName().equalsIgnoreCase("coke")) {
				this.discountPercentage = halfPriceDiscount(item, item.getName(), item.getPrice());
				System.out.println(item.getName() + "  : " + discountPercentage);
			}
			this.totalcost += calculateNormalPrice(item.getQuantity(), item.getPrice());
			System.out.println(item.getName() + "  : £" + item.getPrice() + " : £" + totalcost);
		}
		double discounted = DiscountedAmount();
		double payment = actualPayment(discounted);

		System.out.println("Savings");
		System.out.println("Beans 3 for 2  -£" + discounted);
		System.out.println("total to pay  £" + payment);
		return products;
	}

	private double calculateNormalPrice(double quantity, double price) {
		return quantity * price;
	}

	private double halfPriceDiscount(Product product, String name, double price) {
		if (product.getName().equalsIgnoreCase(name)) {
			price = price / 2;
		}
		return price;

	}

	private double actualPayment(double discounted) {
		return totalcost - discounted;
	}

	private double DiscountedAmount() {
		return totalcost * discountPercentage;
	}

	private double discountPersentage(double quantity, double price) {
		return calculateDiscount(quantity, price) / 100;
	}

	private double calculateDiscount(double quantity, double price) {
		return quantity * 100 / price;
	}

}
