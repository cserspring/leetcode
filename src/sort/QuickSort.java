package sort;

public class QuickSort {

	// Sort a list of numbers in an array within [start, end]
	public void quickSort(int[] A, int start, int end) {
		if (start < end) {
			int pivotLocation = partition(A, start, end);
			quickSort(A, start, pivotLocation - 1);
			quickSort(A, pivotLocation + 1, end);
		}
	}
	
	// Select A[end] as the pivot, separate the array into two parts.
	private int partition(int[] A, int start, int end) {
		int pivot = A[end];
		int i = start;
		for (int j = start; j < end; ++j) {
			if (A[j] <= pivot) {
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
				++i;
			}
		}
		
		A[end] = A[i];
		A[i] = pivot;
		return i;
	}
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] A = { 4, 8, 1, 2, 9, 7, 3, 0, 5, 6 };
		q.quickSort(A, 0, A.length - 1);
		for (int i = 0; i < A.length; ++i) {
			System.out.println(A[i]);
		}
	}

}
