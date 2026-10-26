package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Selection sort for Product arrays, arranging them in descending order.
 */
public class SelectionSort
{
	/**
	 * Sorts the products from largest to smallest using Product's compareTo().
	 *
	 * @param arr the array of products to sort in place
	 */
	public static void sort( Product[] arr )
	{
		for ( int i = 0; i < arr.length - 1; i++ )
		{
			// find the largest remaining element
			int maxIndex = i;
			for ( int j = i + 1; j < arr.length; j++ )
			{
				if ( arr[j].compareTo( arr[maxIndex] ) > 0 )
				{
					maxIndex = j;
				}
			}

			if ( maxIndex != i )
			{
				Product temp = arr[i];
				arr[i] = arr[maxIndex];
				arr[maxIndex] = temp;
			}
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
		for ( int i = 0; i < arr.length - 1; i++ )
		{
			// find the largest remaining element
			int maxIndex = i;
			for ( int j = i + 1; j < arr.length; j++ )
			{
				if ( comp.compare( arr[j], arr[maxIndex] ) > 0 )
				{
					maxIndex = j;
				}
			}

			if ( maxIndex != i )
			{
				Product temp = arr[i];
				arr[i] = arr[maxIndex];
				arr[maxIndex] = temp;
			}
		}
	}
}
