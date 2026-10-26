package products;

public class TShirts extends Product {
	
	public TShirts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	// calculates the real price difference using the TShirts adjustment of 0.2
	@Override
	public double calcRealDiff() {
		return 0.2 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
