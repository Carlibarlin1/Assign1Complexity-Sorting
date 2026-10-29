package products;

/**
 * Represents a Shorts product.
 * Calculates the adjusted difference between
 * the original and updated prices.
 */

public class Shorts extends Product {
    /**
     * Creates a Shorts product.
     *
     * @param originalPrice the original price
     * @param updatedPrice the updated price
     */
	
	public Shorts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}

	 /**
     * Calculates the real price difference
     * using the Shorts adjustment of 0.3.
     *
     * @return the adjusted price difference
     */	@Override
	public double calcRealDiff() {
		return 0.3 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
