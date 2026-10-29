package products;

/**
 * Represents a Jackets product.
 * Calculates the adjusted difference between
 * the original and updated prices.
 */

public class Jackets extends Product {
    /**
     * Creates a Jackets product.
     *
     * @param originalPrice the original price
     * @param updatedPrice the updated price
     */
	
	public Jackets(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	 /**
     * Calculates the real price difference
     * using the Jackets adjustment of 0.7.
     *
     * @return the adjusted price difference
     */	@Override
	public double calcRealDiff() {
		return 0.7 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
