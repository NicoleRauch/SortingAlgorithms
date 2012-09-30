import java.awt.Color;

/*
 * Created on 17.04.2003
 *
 * This class provides an array which also draws its points onto
 * the given canvas. If a point is taken from the array, it is
 * painted in white. If it is put into  the array, it is painted in
 * black. Additionally, each put increases  the copy counter.
 * Comparisons increase the comparison counter.
 */

/**
 * @author rauch
 */
public class SortArray {
	private int[] array;
	private SortCanvas c;
	
	public SortArray(){
		c = new SortCanvas();
		array = new int[1];
	}
	
	public SortArray( SortCanvas canvas ){
		c = canvas;
		array = new int[1];
	}
	
	public SortArray( int n, SortCanvas canvas ){
		c = canvas;
		array = new int[n];
	}
	
	public void copy( int[] a ){
		array = (int[]) a.clone();
	}

	public void copy( SortArray s ){
		c = s.c;
		array = (int[]) s.array.clone();
	}
	
	/** returns the value stored in position i, and paints the 
	 * corresponding point white. Counts as one copy operation.
	 * 
	 * @param i  -- the array index
	 * @return int  -- the value stored at index i
	 */
	public int get(int i){
		c.IncCopy();
		c.paintOne(i, array[i], Color.white);
		return array[i];
	}

	/** returns the array entry at index i without any other modifications.
	 * Must not be used from within a sorting algorithm.
	 * @param i  -- array index
	 * @return int  -- entry at array index i
	 */
	int getValueOnly(int i) {
		return array[i];
	}

	/** inserts the value into position i, and paints the corresponding
	 * point black. Counts as one copy operation.
	 * @param i -- the array index
	 * @param value  -- the value to be inserted
	 */
	public void put( int i, int value ){
		c.IncCopy();
		array[i] = value;
		c.paintOne(i, array[i], Color.black);
	}
	
	/** swaps two array entries. Updates the canvas and counts the
	 * copy operations.
	 * @param i  -- first array index
	 * @param j  -- second array index
	 */
	public void swap( int i, int j ){
		c.paintOne(i, array[i], Color.white);
		c.paintOne(j, array[j], Color.white);
		int h = array[i];
		array[i] = array[j];
		array[j] = h;
		c.IncCopy();
		c.IncCopy();
		c.IncCopy();
		c.paintOne(i, array[i], Color.black);
		c.paintOne(j, array[j], Color.black);
	}
	
	/** compares the two array entries i and j. Returns true if the
	 * entry at i is greater than the entry at j.
	 * @param i  -- the first array entry
	 * @param j -- the second array entry
	 * @return boolean  -- true iff value at i is greater than value at j
	 */
	public boolean greater( int i, int j ){
		c.IncCompare();
		return array[i] > array[j];	
	}
	
	/** compares the array entry i to the integer external. Returns true if the
	 * entry at i is greater than external.
	 * @param i  -- the first array entry
	 * @param external -- the integer value to be compared to
	 * @return boolean  -- true iff value at i is greater than external
	 */
	public boolean greaterInt( int i, int external ){
		c.IncCompare();
		return array[i] > external;	
	}
	
	/** compares the two array entries i and j. Returns true if the
	 * entry at i is greater or equal than the entry at j.
	 * @param i  -- the first array entry
	 * @param j -- the second array entry
	 * @return boolean  -- true iff value at i is greater or equal than value at j
	 */
	public boolean greater_equal( int i, int j ){	
		c.IncCompare();
		return array[i] >= array[j];	
	}

	/** compares the two array entries i and j. Returns true if the
	 * entry at i is less than the entry at j.
	 * @param i  -- the first array entry
	 * @param j -- the second array entry
	 * @return boolean  -- true iff value at i is less than value at j
	 */
	public boolean less( int i, int j ){	
		c.IncCompare();
		return array[i] < array[j];	
	}

	/** compares the two array entries i and j. Returns true if the
	 * entry at i is less or equal than the entry at j.
	 * @param i  -- the first array entry
	 * @param j -- the second array entry
	 * @return boolean  -- true iff value at i is less or equal than value at j
	 */
	boolean less_equal( int i, int j ){	
		c.IncCompare();
		return array[i] <= array[j];	
	}
	
	/** compares the two array entries i and j. Returns true if the
	 * entry at i is equal the entry at j.
	 * @param i  -- the first array entry
	 * @param j -- the second array entry
	 * @return boolean  -- true iff value at i is equal to value at j
	 */
	public boolean equal( int i, int j ){	
		c.IncCompare();
		return array[i] == array[j];	
	}
	
	/** returns the length of the array
	 * 
	 * @return int -- the length of the array
	 */
	public int length(){
		return array.length;
	}

	

}
