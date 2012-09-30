


class CountingSort extends SortingAlgorithm {

    public void sort( SortArray points, SortCanvas c ) {

		int[] indices = new int[points.length()-1 + 30];
		SortArray help = new SortArray();
		help.copy(points);
		int i, index, value;

		for( i = 1; i < points.length()-1 + 30; i++ )
				indices[i] = 0;  // initially set all indices to zero
		for( i = 1; i <= points.length()-1; i++ )
				// count how often a number occurs
				indices[ points.get(i) ]++;  
		for( i = 2; i < points.length()-1 + 30; i++ )
				// count all elements up to any number
				indices[i] += indices[i - 1];
				
		for( i = 1; i <= points.length()-1; i++ ){
			// read a number, get its index, insert it at the correct pos.
			value = help.get(i);
			index = indices[ value ];
		    points.put(index, value);
			indices[ value ]--;
		    c.paintNumbers();
		}

    }

}
