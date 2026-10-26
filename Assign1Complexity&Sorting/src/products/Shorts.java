package products;

public class Shorts extends Product {
	
	public Shorts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}

	// calculates the real price difference using the Shorts adjustment of 0.3
	@Override
	public double calcRealDiff() {
		return 0.3 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
