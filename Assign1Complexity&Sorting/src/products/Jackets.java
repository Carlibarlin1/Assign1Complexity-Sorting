package products;

public class Jackets extends Product {
	
	public Jackets(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	// calculates the real price difference using the Jackets adjustment of 0.7
	@Override
	public double calcRealDiff() {
		return 0.7 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
