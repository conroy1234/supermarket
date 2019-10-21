package kata.supermarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * You have the task to write a component that can calculate the total amount to pay for a supermarket basket. Products are sold by unit or weight, for example 1 coke or 0.450kg of oranges. The supermarket also wants to provide discounts on certain item combinations, for example:

Three cans of beans for the price of two.
Two cans of Coke, for £1.
Example
Use the following example of a receipt to know what data needs to be available. There's no requirement to format or print a receipt.

Beans                0.50
Beans                0.50
Beans                0.50
Coke                 0.70
Coke                 0.70
Oranges
0.200 kg @  £1.99/kg 0.40
                    -----
Sub-total            3.30

Savings
Beans 3 for 2       -0.50
Coke 2 for £1       -0.40
                    -----
Total savings       -0.90
-------------------------
Total to Pay         2.40
 */

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private double price;
	private String name;
	private int quantity;

	public Product() {

	}

	
	public Product(double price, String name, int quantity) {
		this.price = price;
		this.name = name;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + ", quantity=" + quantity + "]";
	}

}
