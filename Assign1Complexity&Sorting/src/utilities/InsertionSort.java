package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Insertion sort for Product arrays, arranging them in descending order.
 */
public class InsertionSort
{
	/**
	 * Sorts the products from largest to smallest using Product's compareTo().
	 *
	 * @param arr the array of products to sort in place
	 */
	public static void sort( Product[] arr )
	{
		for ( int i = 1; i < arr.length; i++ )
		{
			Product key = arr[i];
			int j = i - 1;
			while ( j >= 0 && arr[j].compareTo( key ) < 0 )
			{
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
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
		for ( int i = 1; i < arr.length; i++ )
		{
			Product key = arr[i];
			int j = i - 1;
			while ( j >= 0 && comp.compare( arr[j], key ) < 0 )
			{
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}