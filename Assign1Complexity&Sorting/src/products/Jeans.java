package products;

public class Jeans extends Product {
	
	public Jeans(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	// calculates the real price difference using the Jeans adjustment of 0.5
	@Override 
	public double calcRealDiff() {
		return 0.5 * Math.abs(
			getOriginalPrice() - getUpdatedPrice()	
		);
	}
}
