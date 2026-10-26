package products;

public class Dresses extends Product {
	
	public Dresses(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	// calculates the real price difference using the Dresses adjustment of 0.6
	@Override
	public double calcRealDiff() {
		return 0.6 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
