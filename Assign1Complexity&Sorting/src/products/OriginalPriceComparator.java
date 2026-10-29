package products;

import java.util.Comparator;

/**
 * Compares products using their original prices.
 */

public class OriginalPriceComparator implements Comparator<Product> {
	
    /**
     * Compares the original prices of two products.
     *
     * @param p1 first product
     * @param p2 second product
     * @return negative, zero, or positive
     */
	@Override
	public int compare(Product p1, Product p2) {
		return Double.compare(
			p1.getOriginalPrice(),
			p2.getOriginalPrice()
		);
	}
}
