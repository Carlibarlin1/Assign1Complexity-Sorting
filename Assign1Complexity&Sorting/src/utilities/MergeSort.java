package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Merge sort for Product arrays, arranging them in descending order.
 *
 * Merge sort is divide and conquer: split the array in half, sort each
 * half (recursively), then merge the two sorted halves back together.
 * No generics here - the array is Product[] and ordering comes from
 * Product's compareTo() (Comparable) or a Comparator<Product>.
 */
public class MergeSort
{
	/**
	 * Sorts   the products from largest to smallest using Product's compareTo().
	 *
	 * @param arr the array of products to sort in place
	 */
	public static void sort( Product[] arr )
	{
		if ( arr == null || arr.length < 2 )
		{
			return;
		}
		Product[] temp = new Product[arr.length];          // one shared scratch array
		mergeSort( arr, temp, 0, arr.length - 1 );         // sort whole array
	}

	/**
	 * Sorts the products from largest to smallest using the given comparator.
	 *
	 * @param arr the array of products to sort in place
	 * @param comp the comparator that defines the ordering
	 */
	public static void sort( Product[] arr, Comparator<Product> comp )
	{
		if ( arr == null || arr.length < 2 )
		{
			return;
		}
		Product[] temp = new Product[arr.length];          // one shared scratch array
		mergeSort( arr, temp, 0, arr.length - 1, comp );   // sort whole array
	}

	/**
	 * Recursively splits arr[low..high]  in half, sorts each half, then merges.
	 *
	 * @param arr the array being sorted
	 * @param temp scratch space, same length as arr
	 * @param low index of the first element in this section
	 * @param high index of the last element in this section
	 */
	private static void mergeSort( Product[] arr, Product[] temp, int low, int high )
	{
		if ( low >= high )
		{
			return;
		}
		int mid = ( low + high ) / 2;                       // middle index
		mergeSort( arr, temp, low, mid );                  // sort left half
		mergeSort( arr, temp, mid + 1, high );             // sort right half
		merge( arr, temp, low, mid, high );                // combine the halves
	}

	/** Comparator version of mergeSort - identical except merge uses comp. */
	private static void mergeSort( Product[] arr, Product[] temp, int low, int high,
			Comparator<Product> comp )
	{
		if ( low >= high )
		{
			return;
		}
		int mid = ( low + high ) / 2;                       // middle index
		mergeSort( arr, temp, low, mid, comp );            // sort left half
		mergeSort( arr, temp, mid + 1, high, comp );       // sort right half
		merge( arr, temp, low, mid, high, comp );          // combine the halves
	}

	/**
	 * Merges two already-sorted neighbouring sectionss, arr[low..mid] and
	 * arr[mid+1..high], into one sorted section (descending).
	 *
	 * @param arr the array being sorted
	 * @param temp scratch space, same length as arr
	 * @param low start of the left section
	 * @param mid end of the left section
	 * @param high end of the right section
	 */
	private static void merge( Product[] arr, Product[] temp, int low, int mid, int high )
	{
		for ( int n = low; n <= high; n++ )
		{
			temp[n] = arr[n];                              // copy section to temp
		}

		int i = low;                                       
		int j = mid + 1;                                   
		int k = low;                                       

		while ( i <= mid && j <= high )
		{
			if ( temp[i].compareTo( temp[j] ) >= 0 )       
			{
				arr[k] = temp[i];                      
				i++;
				k++;
			}
			else
			{
				arr[k] = temp[j];                      
				j++;
				k++;
			}
		}

		while ( i <= mid )
		{
			arr[k] = temp[i];                          
			i++;
			k++;
		}
		
	}

	/** Comparator version of merge - uses comp.compare() instead of compareTo(). */
	private static void merge( Product[] arr, Product[] temp, int low, int mid, int high,
			Comparator<Product> comp )
	{
		for ( int n = low; n <= high; n++ )
		{
			temp[n] = arr[n];                              // copy section to temp
		}

		int i = low;                                       // left half pointer
		int j = mid + 1;                                   // right half pointer
		int k = low;                                       // write position

		while ( i <= mid && j <= high )
		{
			if ( comp.compare( temp[i], temp[j] ) >= 0 )   // left bigger or tie
			{
				arr[k] = temp[i];                      // take left (stable)
				i++;
				k++;
			}
			else
			{
				arr[k] = temp[j];                      // take right
				j++;
				k++;
			}
		}

		while ( i <= mid )
		{
			arr[k] = temp[i];                          // copy left leftovers
			i++;
			k++;
		}
		// right leftovers are already in place
	}
}
