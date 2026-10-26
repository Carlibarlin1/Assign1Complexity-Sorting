
package products;

public class ProductTestdeletelater {

    public static void main(String[] args) {

        Product jeans = new Jeans(20.0, 50.0);
        Product shirts = new TShirts(30.0, 50.0);
        Product jackets = new Jackets(40.0, 100.0);

        // Test real differences
        System.out.println("Real Differences:");
        System.out.println("Jeans: " + jeans.calcRealDiff());
        System.out.println("TShirts: " + shirts.calcRealDiff());
        System.out.println("Jackets: " + jackets.calcRealDiff());

        // Test Comparable
        System.out.println("\nCompare Real Differences:");
        System.out.println("Jeans vs TShirts: "
                + jeans.compareTo(shirts));

        // Test original price comparator
        OriginalPriceComparator original =
                new OriginalPriceComparator();

        System.out.println("\nCompare Original Prices:");
        System.out.println("Jeans vs TShirts: "
                + original.compare(jeans, shirts));

        // Test updated price comparator
        UpdatedPriceComparator updated =
                new UpdatedPriceComparator();

        System.out.println("\nCompare Updated Prices:");
        System.out.println("Jeans vs TShirts: "
                + updated.compare(jeans, shirts));
        

		Product skirts = new Skirts(20.0, 50.0);
		Product dresses = new Dresses(20.0, 50.0);
		Product shorts = new Shorts(20.0, 50.0);
		Product shoes = new Shoes(20.0, 50.0);
		
		System.out.println("\nRemaining Product Tests:");
		System.out.println("Skirts: " + skirts.calcRealDiff());
		System.out.println("Dresses: " + dresses.calcRealDiff());
		System.out.println("Shorts: " + shorts.calcRealDiff());
		System.out.println("Shoes: " + shoes.calcRealDiff());
		
		System.out.println("\nComparison Contract Tests:");
		System.out.println("Equal products: "
		        + jeans.compareTo(new Jeans(20.0, 50.0)));
		System.out.println("TShirts vs Jeans: "
		        + shirts.compareTo(jeans));

    }
}
