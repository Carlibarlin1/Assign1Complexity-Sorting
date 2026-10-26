package products;

public class Skirts extends Product {
	
	public Skirts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	// calculates the real price difference using the Skirts adjustment of 0.1
	@Override
	public double calcRealDiff() {
		return 0.1 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
