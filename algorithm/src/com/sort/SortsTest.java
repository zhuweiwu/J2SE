package com.sort;

public class SortsTest {
	public static void main(String[] args) {
		int[] arr ={3,9,2,4,6,5,10,5};
		int[] arr2 = Sorts.bubbleSort(arr);
		int[] arr3 = Sorts.selectSort(arr);
		int[] arr4 = Sorts.insertSort(arr);
		int[] arr5 = Sorts.binInsertSort(arr);
		int[] arr6 = Sorts.shellSort(arr);
		int[] arr7 = Sorts.heapSort(arr);
		int[] arr8 = Sorts.quickSort(arr);
		int[] arr9 = Sorts.mergeSort(arr);
		
		System.out.print("Original Array: ");
		toString(arr);
		System.out.print("Bubble Sort Array: ");
		toString(arr2);
		System.out.print("Select Sort Array: ");
		toString(arr3);
		System.out.print("Insert Sort Array: ");
		toString(arr4);
		System.out.print("Binary Insert Sort Array: ");
		toString(arr5);
		System.out.print("Shell Sort Array: ");
		toString(arr6);
		System.out.print("Heap Sort Array: ");
		toString(arr7);
		System.out.print("Quick Sort Array: ");
		toString(arr8);
		System.out.print("Merge Sort Array: ");
		toString(arr9);
		
	}
	
	
	public static void toString(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
