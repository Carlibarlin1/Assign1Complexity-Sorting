package products;

import java.util.Comparator;


/**
 * Compares products using their updated prices.
 */

public class UpdatedPriceComparator implements Comparator<Product> {
	
    /**
     * Compares the updated prices of two products.
     *
     * @param p1 first product
     * @param p2 second product
     * @return negative, zero, or positive
     */
	@Override
	public int compare(Product p1, Product p2) {
		return Double.compare(
			p2.getUpdatedPrice(),
			p2.getUpdatedPrice()
		);
	}

}
