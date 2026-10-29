package products;

/**
 * Represents a Shoes product.
 * Calculates the adjusted difference between
 * the original and updated prices.
 */

public class Shoes extends Product {
    /**
     * Creates a Shoes product.
     *
     * @param originalPrice the original price
     * @param updatedPrice the updated price
     */
	
	public Shoes(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	 /**
     * Calculates the real price difference
     * using the Shoes adjustment of 0.4.
     *
     * @return the adjusted price difference
     */	@Override
	public double calcRealDiff() {
		return 0.4 * Math.abs(getOriginalPrice() - getUpdatedPrice());
	}

}
