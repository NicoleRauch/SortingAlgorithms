


class InsertionSort extends SortingAlgorithm {

    public void sort( SortArray points, SortCanvas c ) {

        int i, j, value_i;       

        points.put(0, 0); 
        for( i = 2; i < points.length(); i++){
            j = i;
            value_i = points.get(i);
            while( points.greaterInt( j-1, value_i )){
            	points.put(j, points.get(j-1));
                j--;
            }
            points.put(j, value_i);
            
            c.paintNumbers();
        }


    }

}
