package products;

import java.util.Comparator;

public class UpdatedPriceComparator implements Comparator<Product> {
	
	// compares the updated prices of two products
	@Override
	public int compare(Product p1, Product p2) {
		return Double.compare(
			p1.getUpdatedPrice(),
			p2.getUpdatedPrice()
		);
	}

}
