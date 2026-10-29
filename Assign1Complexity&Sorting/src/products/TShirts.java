package products;

/**
 * Represents a TShirts product.
 * Calculates the adjusted difference between
 * the original and updated prices.
 */

public class TShirts extends Product {
    /**
     * Creates a TShirts product.
     *
     * @param originalPrice the original price
     * @param updatedPrice the updated price
     */
	
	public TShirts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
    /**
     * Calculates the real price difference
     * using the TShirts adjustment of 0.2.
     *
     * @return the adjusted price difference
     */
	@Override
	public double calcRealDiff() {
		return 0.2 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
