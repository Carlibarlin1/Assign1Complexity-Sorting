package products;

/**
 * Represents a Dresses product.
 * Calculates the adjusted difference between
 * the original and updated prices.
 */

public class Dresses extends Product {
    /**
     * Creates a Dresses product.
     *
     * @param originalPrice the original price
     * @param updatedPrice the updated price
     */

	public Dresses(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	 /**
     * Calculates the real price difference
     * using the Dresses adjustment of 0.6.
     *
     * @return the adjusted price difference
     */	@Override
	public double calcRealDiff() {
		return 0.6 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
