package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Bubble sort for Product arrays, arranging them in descending order.
 */
public class BubbleSort
{
	/**
	 * Sorts the products from largest to smallest using Product's compareTo().
	 *
	 * @param arr the array of products to sort in place
	 */
	public static void sort( Product[] arr )
	{
		for ( int pass = 0; pass < arr.length - 1; pass++ )
		{
			boolean swapped = false;
			for ( int j = 0; j < arr.length - 1 - pass; j++ )
			{
				if ( arr[j].compareTo( arr[j + 1] ) < 0 )
				{
					Product temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if ( !swapped ) break;
		}
	}

	/**
	 * Sorts the products from largest to smallest using the given comparator.
	 *
	 * @param arr the array of products to sort in place
	 * @param comp the comparator that defines the ordering
	 */
	public static void sort( Product[] arr, Comparator<Product> comp )
	{
		for ( int pass = 0; pass < arr.length - 1; pass++ )
		{
			boolean swapped = false;
			for ( int j = 0; j < arr.length - 1 - pass; j++ )
			{
				if ( comp.compare( arr[j], arr[j + 1] ) < 0 )
				{
					Product temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if ( !swapped ) break;
		}
	}
}