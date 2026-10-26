package products;

import java.util.Comparator;

public class OriginalPriceComparator implements Comparator<Product> {
	
	// compares the original price of two products
	@Override
	public int compare(Product p1, Product p2) {
		return Double.compare(
			p1.getOriginalPrice(),
			p2.getOriginalPrice()
		);
	}
}
