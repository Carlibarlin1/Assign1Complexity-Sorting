package products;

/**
 * Represents a Skirts product.
 * Calculates the adjusted difference between
 * the original and updated prices.
 */

public class Skirts extends Product {
    /**
     * Creates a Skirts product.
     *
     * @param originalPrice the original price
     * @param updatedPrice the updated price
     */
	
	public Skirts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	 /**
     * Calculates the real price difference
     * using the Skirts adjustment of 0.1.
     *
     * @return the adjusted price difference
     */	@Override
	public double calcRealDiff() {
		return 0.1 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
