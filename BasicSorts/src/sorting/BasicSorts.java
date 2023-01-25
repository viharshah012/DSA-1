package sorting;

public class BasicSorts {
	
	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static<T> void swap(T[] list, int i, int j) {
		/*OPTIONAL TODO: IMPLEMENT THIS METHOD*/
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;		
	}
	
	/*
	 * Updates the elements of list to be in sorted order. Uses "bubble sort"
	 * */
	public static<T extends Comparable<T>> void bubbleSort(T[] list) {
		/* TODO: IMPLEMENT THIS METHOD */
		for(int i = 0; i < list.length-1; i++) {
			for(int j = 0; j < list.length-1-i;j++) {
				if(list[j].compareTo(list[j+1]) > 0) {
					swap(list, j, j+1);
				}
			}		
		}
	}
	
	/*
	 * Updates the elements of list to be in sorted order. Uses "insertion sort"
	 * */
	public static<T extends Comparable<T>> void insertionSort(T[] list) {
		/* TODO: IMPLEMENT THIS METHOD */
		for(int i = 1; i < list.length; i++) {
			T pointer = list[i];
			int j = i-1;
			while((j > -1) && (pointer.compareTo(list[j]) < 0)) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = pointer;
		}
	}
	
}
