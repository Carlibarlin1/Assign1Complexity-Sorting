package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Heap sort for Product arrays, arranging them in descending order.
 *
 * Heap sort treats the array as a binary tree stored in place:
 *     parent of i      = ( i - 1 ) / 2
 *     left child of i  = 2 * i + 1
 *     right child of i = 2 * i + 2
 *
 * To sort DESCENDING we use a MIN-heap (smallest value at the root).
 * Repeatedly swapping the root (the smallest) with the last element of the
 * heap pushes the smallest values to the end of the array, which leaves the
 * largest at the front. (A max-heap would give ascending order, which is not
 * allowed to be reversed afterwards.)
 */
public class HeapSort
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

		for ( int i = arr.length / 2 - 1; i >= 0; i-- )    // last parent up to root
		{
			heapify( arr, arr.length, i );                 // build min-heap
		}

		for ( int end = arr.length - 1; end > 0; end-- )
		{
			swap( arr, 0, end );                           // smallest to the back
			heapify( arr, end, 0 );                        // repair shrunken heap
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
		if ( arr == null || arr.length < 2 )
		{
			return;
		}

		for ( int i = arr.length / 2 - 1; i >= 0; i-- )    // last parent up to root
		{
			heapify( arr, arr.length, i, comp );           // build min-heap
		}

		for ( int end = arr.length - 1; end > 0; end-- )
		{
			swap( arr, 0, end );                           // smallest to the back
			heapify( arr, end, 0, comp );                  // repair shrunken heap
		}
	}

	/**
	 * Sifts arr[i] down until the min-heap property holds for the subtree.
	 *
	 * @param arr the array holding the heap
	 * @param size how many elements at the front of arr are still in the heap
	 * @param i index of the element to sift down
	 */
	private static void heapify( Product[] arr, int size, int i )
	{
		int smallest = i;                                  // assume parent smallest
		int left = 2 * i + 1;                              // left child index
		int right = 2 * i + 2;                             // right child index

		if ( left < size && arr[left].compareTo( arr[smallest] ) < 0 )
		{
			smallest = left;                               // left is smaller
		}
		if ( right < size && arr[right].compareTo( arr[smallest] ) < 0 )
		{
			smallest = right;                              // right is smaller
		}

		if ( smallest != i )                               // parent was not smallest
		{
			swap( arr, i, smallest );                      // push parent down
			heapify( arr, size, smallest );                // fix the lower subtree
		}
	}

	/** Comparator version of heapify - uses comp.compare(). */
	private static void heapify( Product[] arr, int size, int i, Comparator<Product> comp )
	{
		int smallest = i;                                  // assume parent smallest
		int left = 2 * i + 1;                              // left child index
		int right = 2 * i + 2;                             // right child index

		if ( left < size && comp.compare( arr[left], arr[smallest] ) < 0 )
		{
			smallest = left;                               // left is smaller
		}
		if ( right < size && comp.compare( arr[right], arr[smallest] ) < 0 )
		{
			smallest = right;                              // right is smaller
		}

		if ( smallest != i )                               // parent was not smallest
		{
			swap( arr, i, smallest );                      // push parent down
			heapify( arr, size, smallest, comp );          // fix the lower subtree
		}
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
