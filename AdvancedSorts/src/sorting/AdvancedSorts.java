package sorting;

public class AdvancedSorts {

	
	
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(i < j) {
			int mid = (i+j)/2;
			mergeSort(list, i, mid);
			mergeSort(list, mid+1, j);
			merge(list, i, mid, j);
		}
	}
	
	private static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		int asize = mid-i+1;
		int bsize = j-mid;
		T[] listA = (T[]) new Comparable[asize];
		T[] listB = (T[]) new Comparable[bsize];
		T[] finallist = (T[]) new Comparable[j-i+1];
		
		for(int k = 0; k < asize; k++) {
			listA[k] = list[i + k];
		}
		for(int m = 0; m < bsize; m++) {
			listB[m] = list[mid + m + 1];
		}
		
		int k = 0;
		int m = 0;
		int n = i;
		
		while(k < asize && m < bsize) {
			if(listA[k].compareTo(listB[m]) <= 0) {
				list[n] = listA[k];
				k++;
			}
			else {
				list[n] = listB[m];
				m++;
			}
			n++;
		}
		
		while(k < listA.length) {
			list[n++] = listA[k++];
		}
		while(m < listB.length) {
			list[n++] = listB[m++];
		}
	}
	
	
	
	
	
	
	
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(i < j) {
			int pivot = partition(list, i, j);
			quickSort(list, i, pivot-1);
			quickSort(list, pivot+1, j);
		}
	}
	
	private static<T extends Comparable<T>> int partition(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		T pivot = list[j];
		int k = (i - 1);
		for (int m = i; m < j; m++) {
			if (list[m].compareTo(pivot) <= 0) {
				k++;
				
				T temp = list[k];
		        list[k] = list[m];
		        list[m] = temp;
			}
		}
		
		T temp2 = list[k+1];
		list[k+1] = list[j];
		list[j] = temp2;
		
		return (k+1);
		
	}
	
	
	
	
	

}
