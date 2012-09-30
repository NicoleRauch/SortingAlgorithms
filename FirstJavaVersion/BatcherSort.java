
class BatcherSort extends SortingAlgorithm {
	
	SortArray work;
	SortCanvas c;

	/****************************************************************\
	 * Function name: sort()
	 *
	 * Returns: VOID
	 *
	 * Purpose:  This routine is a stub that calls the recursive Batcher sort
	 *           with the proper initial arguments.
	 *
	 * Usage:  It passes the pcp, the size of the array to be sorted,
	 *                  the offset to start sorting at(1), the number
	 *                  of elements each item is from neighboring elements (1),
	 *                  and Half flag to sort the halves (true=YES).
	\****************************************************************/
	public void sort(SortArray points, SortCanvas canvas) {
		work = new SortArray();
		work.copy(points);
		c = canvas;
		batcherSort(work.length()-1, 1, 1, true);
	}

	/****************************************************************\
	 * Function name: BatcherSortR()
	 *
	 * Parameters:  pcp is a struct which contains the continue flag,
	 *              a pointer to the data array.
	 *              None of the other pcp members are used.
	 *              usArrSize is the number of elements in the current sort set.
	 *              usStart is the offset to the 1st element in the set.
	 *              usSkip is the spacing between consecutive elements.
	 *              fHalves sorts the 2 halves when set, otherwise skips the
	 *                      1st 2 of the 4 sub-sorts.
	 *
	 * Returns: VOID
	 *
	 * Purpose:  Implements Batcher sort which is O(n lg n).  The advantage
	 *           of the batcher sort is that the comparisons made do NOT
	 *           depend upon the outcome of previous comparisons.  This makes
	 *           it a good algorithm for parallelism.  The algorithm works as
	 *           follows:  Sort the first half, sort the second half, sort the
	 *           odd elements, sort the even elements, then compare swap
	 *           elements 2/3, 4/5, ...
	 *
	 * Usage  :  There are several adaptations to the algorithm to
	 *                  allow it to work with arbitrary sized data sets
	 *                  (the original required a power of 2 sized data
	 *                  set):  if the set size is less than 2, the routine
	 *                  returns, the first "half" is always the largest
	 *                  possible power of two, and the top value for the
	 *                  final compare/swap is adjusted to round up in
	 *                  case of an odd data set.
	 *                  Another optimization is that involving the fHalves
	 *                  flag.  This stems from the observation that when
	 *                  the odd/even sort recurses, the first and second
	 *                  halves are already sorted, thus the first 2
	 *                  recursive calls are unnecessary in this case.
	 *
	\****************************************************************/
	void batcherSort(
		int ulArrSize,
		int ulStart,
		int ulSkip,
		boolean fHalves) {
		int cnt, ulUpper, ulTemp; /* Utility variables */

		if (ulArrSize < 2) /* No sorting needed if <2 items in the set */
			return;

		if (ulArrSize == 2) {
		/* Do simple compare/swap if there are 2 elements */
			if (work.greater(ulStart,ulStart + ulSkip)) {
				work.swap(ulStart, ulStart+ulSkip);
			}
			c.paintNumbers();
			return;
		}

		ulTemp = 1; /* ulTemp ends up holding the smallest power */
		while (ulTemp < ulArrSize)
			/* of 2 that is at least as big as ulArrSize */
			ulTemp *= 2;

		if (fHalves) /* If the sort was NOT called by the odd/even recurses */ {
			batcherSort((int) (ulTemp / 2), ulStart, ulSkip, true);
			/* Sort 1st half */
			batcherSort((int) (ulArrSize - ulTemp / 2), /* Sort 2nd half */
			 (int) (ulStart + ulTemp / 2 * ulSkip), ulSkip, true);
		}
		batcherSort(
			(int) (ulArrSize - ulArrSize / 2),
			ulStart,
			(int) (ulSkip * 2),
			false);
		/* Sort evens */
		batcherSort(
			(int) (ulArrSize / 2),
			(int) (ulStart + ulSkip),
			(int) (ulSkip * 2),
			false);
		/* Sort odds  */

		ulUpper =
			(int) (ulStart
				+ ulSkip
				+ (ulArrSize - ulArrSize / 2 - 1) * 2 * ulSkip);
		for (cnt = ulStart + ulSkip;
			cnt < ulUpper;
			cnt += ulSkip * 2) /* Do final compares */ {
			if (work.greater(cnt, cnt + ulSkip)) {
				work.swap(cnt, cnt+ulSkip);				
				c.paintNumbers();
			}
		}
		return;
	}

}
