package products;

/**
 * Represents a product with an original price
 * and an updated price.
 *
 * Products are compared using their calculated
 * real price difference.
 */
public abstract class Product implements Comparable {
	
	private double originalPrice;
	private double updatedPrice;
	
	public Product(double originalPrice, double updatedPrice) {
		this.originalPrice = originalPrice;
		this.updatedPrice = updatedPrice;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public double getUpdatedPrice() {
		return updatedPrice;
	}
	
	public abstract double calcRealDiff();
	
	@Override
	public int compareTo(Object obj) {
		Product other = (Product) obj;
		
		return Double.compare(
				this.calcRealDiff(),
				other.calcRealDiff()
		);
	}

}
