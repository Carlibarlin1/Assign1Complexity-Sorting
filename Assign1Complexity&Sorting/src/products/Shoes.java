package products;

public class Shoes extends Product {
	
	public Shoes(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	// calculates the real price difference using the Shoes adjustment of 0.4
	@Override
	public double calcRealDiff() {
		return 0.4 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
