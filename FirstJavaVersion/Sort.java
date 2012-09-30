

import java.util.Random;


/** Takes an array of points. The x-coordinates are increasingly
 *  numbered, the y-coordinates are initialized in some given way
 *  (e.g. randomly, increasing, decreasing etc.).
 *  The sorting algorithm sorts the y-components of the points.
 * 
 *  Improvement: We need not take an array of points but simply
 *  an array of integers as the x-coordinates match the array index.
 *  
 * @author rauch
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code Template
 */
public class Sort {

    static private int MAX_POINTS;

  	static final protected SortArray points = new SortArray(SortGraphics.canvas), 
  									work = new SortArray(SortGraphics.canvas);  

    static public void initOldNumbers(){
		// copy numbers from original to working copy
		work.copy(points);
		SortGraphics.resetCanvas(work);
    }

    static public void initRandom( int seed ){
         // for some algorithms I need the 0th entry, so I start with the 1st
        
 		Random rand = new Random(seed);
 
 		int[] pointsT = new int[MAX_POINTS+1];
        for( int i = 1; i <= MAX_POINTS; i++ ){
 				pointsT[i] = rand.nextInt(MAX_POINTS);
        }
        points.copy(pointsT);
        
        initOldNumbers();

    }

	static public void initBackwards(){
		int[] pointsT = new int[MAX_POINTS+1];
		for( int i = 1; i <= MAX_POINTS; i++ ){
				pointsT[i] = MAX_POINTS + 1 - i;
		}
		points.copy(pointsT);
		
		initOldNumbers();
	}

	static public void initSorted(){
		int[] pointsT = new int[MAX_POINTS+1];
		for( int i = 1; i <= MAX_POINTS; i++ ){
				pointsT[i] = i;
		}
		points.copy(pointsT);

		initOldNumbers();
	}

    static public void setPointNumber( int num ){
        MAX_POINTS = num;
        initRandom(new Random().nextInt() );
    }

    public static void main( String[] args ){

        SortGraphics s = new SortGraphics();
        
		s.addSort("Insertion Sort", new InsertionSort(), work);
		s.addSort("Merge-Sort", new MergeSort(), work);
		s.addSort("Quicksort", new QuickSort(), work);
		s.addSort("Heapsort", new HeapSort(), work);
		s.addSort("Counting Sort", new CountingSort(), work);
		s.addSort("Bubblesort", new BubbleSort(), work);
		s.addSort("Shell Sort, 3", new ShellSort3(), work);
		s.addSort("Shell Sort, 5", new ShellSort5(), work);
		s.addSort("Shell Sort, 7", new ShellSort7(), work);
		s.addSort("Shell Sort, 9", new ShellSort9(), work);
		s.addSort("Selection Sort", new SelectionSort(), work);
		s.addSort("Bogosort", new BogoSort(), work);
		s.addSort("Batcher Sort", new BatcherSort(), work);
		s.addSort("Bidirectional Bubblesort", new BidirectionalBubbleSort(), 
					work);
		
    }
}
