


class HeapSort extends SortingAlgorithm {

	SortArray points;  // to transport the array to other methods
	SortCanvas c;

    public void sort( SortArray p, SortCanvas canvas ) {
    	points = p;
    	c = canvas;
		int heapsize = points.length()-1;
		int i;

		// build the heap:
		for( i = heapsize / 2; i > 0; i-- ){
				heapify( i, heapsize );
		}
		// sort the heap:
		for( i = heapsize; i > 1; i-- ){
			points.swap(1, i);
			heapsize--;
			heapify( 1, heapsize );
			c.paintNumbers();
		}
    }


	int parent( int i )      // returns father of i if 1 < i <= N
	{
			if( 1 < i && i <= points.length()-1 )
					return i / 2;
			else
					return 0;
	}       
	int left( int i )        // returns left son if 1 <= i <= MAX_POINTS / 2
	{
			if( 1 <= i && i <= (points.length()-1) / 2 )
					return 2 * i;
			else
					return 0;
	}

	int right( int i )       // returns right son    
	{
			if( 1 <= i && i <= (points.length()-1) / 2 )
					return 2 * i + 1;
			else
					return 0;
	}


	void heapify( int i, int heapsize )
	{
			int l, r, largest;

			l = left( i );
			r = right( i );
			c.IncCompare();
			if( l <= heapsize && points.greater(l, i) ){
					largest = l;
			} else 
					largest = i;
			c.IncCompare();
			if( r <= heapsize && points.greater(r, largest) ) {
					largest = r;
			}
			if( largest != i ){
				points.swap(i, largest);
				heapify( largest, heapsize );
			}
	}

}
