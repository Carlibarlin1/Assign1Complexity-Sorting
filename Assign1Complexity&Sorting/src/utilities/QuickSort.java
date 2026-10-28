package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Quick sort for Product arrays, arranging them in descending order.
 * The pivot is chosen with the "median-of-three" approach.
 *
 * Quick sort picks a pivot, partitions the array so everything that belongs
 * BEFORE the pivot (larger values, since we sort descending) is on its left
 * and everything that belongs AFTER it (smaller values) is on its right,
 * then recursively sorts the two sides.
 */
public class QuickSort
{
	/**
	 * Sorts the products from largest to smallest using Product's compareTo().
	 *
	 * @param arr the array of products to sort in place
	 */
	public static void sort( Product[] arr )
	{
		if ( arr == null || arr.length < 2 )
		{
			return;
		}
		quickSort( arr, 0, arr.length - 1 );               // sort whole array
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
		quickSort( arr, 0, arr.length - 1, comp );         // sort whole array
	}

	/**
	 * Recursively sorts arr[low..high].
	 *
	 * @param arr the array being sorted
	 * @param low index of the first element in this section
	 * @param high index of the last element in this section
	 */
	private static void quickSort( Product[] arr, int low, int high )
	{
		if ( low < high )                                  // 2+ elements left
		{
			int p = partition( arr, low, high );           // pivot's final spot
			quickSort( arr, low, p - 1 );                  // sort larger side
			quickSort( arr, p + 1, high );                 // sort smaller side
		}
	}

	/** Comparator version of quickSort. */
	private static void quickSort( Product[] arr, int low, int high, Comparator<Product> comp )
	{
		if ( low < high )                                  // 2+ elements left
		{
			int p = partition( arr, low, high, comp );     // pivot's final spot
			quickSort( arr, low, p - 1, comp );            // sort larger side
			quickSort( arr, p + 1, high, comp );           // sort smaller side
		}
	}

	/**
	 * Median-of-three pivot selection.
	 *
	 * Orders the first, middle and last elements (descending) so the middle
	 * one is the median, then parks that median at index high to act as the
	 * pivot. Avoids the O(n^2) worst case on already-sorted data.
	 *
	 * @param arr the array being sorted
	 * @param low first index of the section
	 * @param high last index of the section
	 * @return the index where the pivot has been parked
	 */
	private static int medianOfThree( Product[] arr, int low, int high )
	{
		int mid = ( low + high ) / 2;                       // middle index

		if ( arr[mid].compareTo( arr[low] ) > 0 )
		{
			swap( arr, mid, low ); // low >= mid
		}
		if ( arr[high].compareTo( arr[low] ) > 0 )
		{
			swap( arr, high, low ); // low >= high
		}
		if ( arr[high].compareTo( arr[mid] ) > 0 )
		{
			swap( arr, high, mid ); // mid >= high
		}

		swap( arr, mid, high );                            // park median at end
		return high;                                       // pivot index
	}

	/** Comparator version of medianOfThree - uses comp.compare(). */
	private static int medianOfThree( Product[] arr, int low, int high, Comparator<Product> comp )
	{
		int mid = ( low + high ) / 2;                       // middle index

		if ( comp.compare( arr[mid], arr[low] ) > 0 )
		{
			swap( arr, mid, low ); 
		}		if ( comp.compare( arr[high], arr[low] ) > 0 )
		{
			swap( arr, high, low ); 
		}		if ( comp.compare( arr[high], arr[mid] ) > 0 )
		{
			swap( arr, high, mid ); 
		}
		swap( arr, mid, high );                            // park median at end
		return high;                                       // pivot index
	}

	/**
	 * Partitions arr[low..high] around the median-of-three pivot.
	 * After partitioning, everything left of the pivot is >= pivot and
	 * everything right of it is <= pivot (descending order).
	 *
	 * @param arr the array being sorted
	 * @param low first index of the section
	 * @param high last index of the section
	 * @return the final index of the pivot
	 */
	private static int partition( Product[] arr, int low, int high )
	{
		int pivotIndex = medianOfThree( arr, low, high );  // choose pivot
		Product pivot = arr[pivotIndex];                   // remember its value
		int i = low;                                       // end of "larger" zone

		for ( int j = low; j < high; j++ )
		{
			if ( arr[j].compareTo( pivot ) > 0 )           // belongs before pivot
			{
				swap( arr, i, j );                         // move into larger zone
				i++;                                       // grow larger zone
			}
		}

		swap( arr, i, high );                              // pivot to final spot
		return i;                                          // pivot's index
	}

	/** Comparator version of partition. */
	private static int partition( Product[] arr, int low, int high, Comparator<Product> comp )
	{
		int pivotIndex = medianOfThree( arr, low, high, comp );  // choose pivot
		Product pivot = arr[pivotIndex];                  
		int i = low;                                       

		for ( int j = low; j < high; j++ )
		{
			if ( comp.compare( arr[j], pivot ) > 0 )       // belongs before 
			{
				swap( arr, i, j );                         // move into larger zone
				i++;                                       // grow larger zone
			}
		}

		swap( arr, i, high );                              // pivot to final spot
		return i;                                          // pivot's index
	}

	/**
	 * Swaps two elements of the array.
	 *
	 * @param arr the array
	 * @param a index of the first element
	 * @param b index of the second element
	 */
	private static void swap( Product[] arr, int a, int b )
	{
		Product temp = arr[a];                             // hold first
		arr[a] = arr[b];                                   // overwrite first
		arr[b] = temp;                                     // restore into second
	}
}
