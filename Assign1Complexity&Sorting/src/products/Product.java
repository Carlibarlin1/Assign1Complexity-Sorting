package products;

/**
 * Represents a product with an original price
 * and an updated price.
 *
 * Products are compared using their calculated
 * real price difference.
 */
public abstract class Product implements Comparable {
	
	private double originalPrice;
	private double updatedPrice;
	
    /**
     * Creates a product with two prices.
     *
     * @param originalPrice the original price
     * @param updatedPrice the updated price
     */
	
	public Product(double originalPrice, double updatedPrice) {
		this.originalPrice = originalPrice;
		this.updatedPrice = updatedPrice;
	}

    /**
     * Returns the original price.
     *
     * @return original price
     */
	public double getOriginalPrice() {
		return originalPrice;
	}
	
    /**
     * Returns the updated price.
     *
     * @return updated price
     */
	public double getUpdatedPrice() {
		return updatedPrice;
	}
	
	 /**
     * Calculates the adjusted price difference.
     *
     * @return calculated real difference
     */
	public abstract double calcRealDiff();
	
    /**
     * Compares products by their real difference.
     *
     * @param obj the object being compared
     * @return negative, zero, or positive
     */
	@Override
	public int compareTo(Object obj) {
		Product other = (Product) obj;
		
		return Double.compare(
				this.calcRealDiff(),
				other.calcRealDiff()
		);
	}

}
