package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import products.Dresses;
import products.Jackets;
import products.Jeans;
import products.OriginalPriceComparator;
import products.Product;
import products.Shoes;
import products.Shorts;
import products.Skirts;
import products.TShirts;
import products.UpdatedPriceComparator;
import utilities.HeapSort;
import utilities.MergeSort;
import utilities.QuickSort;

/**
 * Checks that the sorting algorithms are accurate (output really is in
 * descending order) and measures how long each one takes.
 *
 * Kept separate from the sorts so the sorting code itself has no timing or
 * printing in it.
 */
public class SortTester
{
	/**
	 * Returns true if the array is in descending order by calcRealDiff()
	 * (i.e. every element compares >= the one after it using compareTo()).
	 *
	 * @param arr the array to check
	 * @return true when sorted from largest to smallest
	 */
	public static boolean isSortedDescending( Product[] arr )
	{
		for ( int i = 0; i < arr.length - 1; i++ )
		{
			if ( arr[i].compareTo( arr[i + 1] ) < 0 )      // out of order
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Comparator version of the check.
	 *
	 * @param arr the array to check
	 * @param comp the comparator used for the sort
	 * @return true when sorted from largest to smallest
	 */
	public static boolean isSortedDescending( Product[] arr, Comparator<Product> comp )
	{
		for ( int i = 0; i < arr.length - 1; i++ )
		{
			if ( comp.compare( arr[i], arr[i + 1] ) < 0 )  // out of order
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Reads a products file into a Product array.
	 *
	 * @param fileName path to the data file
	 * @return the products in file order
	 * @throws FileNotFoundException if the file cannot be found
	 */
	private static Product[] load( String fileName ) throws FileNotFoundException
	{
		Scanner in = new Scanner( new File( fileName ) );
		int n = in.nextInt();                              // first value = count
		Product[] list = new Product[n];                   // plain array

		for ( int i = 0; i < n; i++ )
		{
			String type = in.next();                       // product type
			double original = in.nextDouble();             // original price
			double updated = in.nextDouble();              // updated price

			if ( type.equals( "Jeans" ) )
			{
				list[i] = new Jeans( original, updated );
			}
			else if ( type.equals( "TShirts" ) )
			{
				list[i] = new TShirts( original, updated );
			}
			else if ( type.equals( "Skirts" ) )
			{
				list[i] = new Skirts( original, updated );
			}
			else if ( type.equals( "Dresses" ) )
			{
				list[i] = new Dresses( original, updated );
			}
			else if ( type.equals( "Shorts" ) )
			{
				list[i] = new Shorts( original, updated );
			}
			else if ( type.equals( "Jackets" ) )
			{
				list[i] = new Jackets( original, updated );
			}
			else
			{
				list[i] = new Shoes( original, updated );
			}
		}

		in.close();
		return list;
	}

	/**
	 * Makes a separate copy of the array so each sort starts unsorted.
	 *
	 * @param original the array to copy
	 * @return a new array holding the same products
	 */
	private static Product[] copy( Product[] original )
	{
		Product[] result = new Product[original.length];
		for ( int i = 0; i < original.length; i++ )
		{
			result[i] = original[i];
		}
		return result;
	}

	/**
	 * Tests merge, quick and heap sort using compareTo() and prints
	 * PASS/FAIL with the sort time in milliseconds.
	 *
	 * @param data the unsorted products
	 */
	private static void testCompareTo( Product[] data )
	{
		Product[] arr = copy( data );
		long start = System.nanoTime();                    // time the sort only
		MergeSort.sort( arr );
		long end = System.nanoTime();
		print( "Merge sort (diff)", isSortedDescending( arr ), start, end );

		arr = copy( data );
		start = System.nanoTime();
		QuickSort.sort( arr );
		end = System.nanoTime();
		print( "Quick sort (diff)", isSortedDescending( arr ), start, end );

		arr = copy( data );
		start = System.nanoTime();
		HeapSort.sort( arr );
		end = System.nanoTime();
		print( "Heap sort (diff)", isSortedDescending( arr ), start, end );
	}

	/**
	 * Tests merge, quick and heap sort using a comparator and prints
	 * PASS/FAIL with the sort time in milliseconds.
	 *
	 * @param data the unsorted products
	 * @param comp the comparator to sort with
	 * @param label which comparator is being used
	 */
	private static void testComparator( Product[] data, Comparator<Product> comp, String label )
	{
		Product[] arr = copy( data );
		long start = System.nanoTime();                    // time the sort only
		MergeSort.sort( arr, comp );
		long end = System.nanoTime();
		print( "Merge sort (" + label + ")", isSortedDescending( arr, comp ), start, end );

		arr = copy( data );
		start = System.nanoTime();
		QuickSort.sort( arr, comp );
		end = System.nanoTime();
		print( "Quick sort (" + label + ")", isSortedDescending( arr, comp ), start, end );

		arr = copy( data );
		start = System.nanoTime();
		HeapSort.sort( arr, comp );
		end = System.nanoTime();
		print( "Heap sort (" + label + ")", isSortedDescending( arr, comp ), start, end );
	}

	/**
	 * Prints one result line.
	 *
	 * @param name which sort and ordering was tested
	 * @param passed true if the result was in descending order
	 * @param start start time in nanoseconds
	 * @param end end time in nanoseconds
	 */
	private static void print( String name, boolean passed, long start, long end )
	{
		double milliseconds = ( end - start ) / 1000000.0; // nanoseconds to ms
		String result = "FAIL";
		if ( passed )
		{
			result = "PASS";
		}
		System.out.println( name + ": " + result + " - " + milliseconds + " ms" );
	}

	/**
	 * Runs every sort on every data file with all three orderings.
	 *
	 * @param args optional list of data files (defaults to the three in res/)
	 * @throws FileNotFoundException if a data file cannot be found
	 */
	public static void main( String[] args ) throws FileNotFoundException
	{
		String[] files = { "res/products1.txt", "res/products2.txt", "res/products3.txt" };
		if ( args.length > 0 )
		{
			files = args;
		}

		for ( int i = 0; i < files.length; i++ )
		{
			Product[] data = load( files[i] );
			System.out.println( "== " + files[i] + " (" + data.length + " items)" );
			testCompareTo( data );
			testComparator( data, new OriginalPriceComparator(), "original" );
			testComparator( data, new UpdatedPriceComparator(), "updated" );
		}
	}
}
