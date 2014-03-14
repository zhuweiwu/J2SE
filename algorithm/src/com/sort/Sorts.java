package com.sort;

/**
 * Util class of sort: bubblesort, insertsort, selectsort
 * @author zhuwei wu
 * 2014-2-21
 */
public class Sorts {
	private static int[] arrTemp;
	
	/**
	 * Bubble Sort
	 * 
	 * O(N^2)
	 * 
	 * @param arr[]
	 * @return arr[]
	 */
	public static int[] bubbleSort(int[] arr){
		arrTemp = arr.clone();
		int len = arrTemp.length;
		int out, in;
		for(out=len-1; out>1; out--){  //outer loop from arr[n] to arr[2]
			for(in=0; in<out; in++){   //inter loop from arr[0] to arr[n-1]
				if(arrTemp[in]>arrTemp[in+1]){
//					int temp = arrTemp[in];
//					arrTemp[in] = arrTemp[in+1];
//					arrTemp[in+1] = temp;
					swap(in, in+1);
				}
			}
		}
		return arrTemp;
	}
	
	/**
	 * Select Sort: less swap times than bubble sort
	 * 
	 * 	O(N^2)
	 * 
	 * @param arr[]
	 * @return arr[]
	 */
	public static int[] selectSort(int[] arr){
		arrTemp = arr.clone();
		int len = arrTemp.length;
		int out, in, min;
		for(out=0; out<len-1; out++){//outloop from arr[0] to arr[n-1]
			min = out;
			for(in=out+1; in<len; in++){ //interloop from arr[out+1] to arr[n]
				if(arrTemp[in] < arrTemp[min]){
					min = in;
				}				
			}
//			int temp = arrTemp[min];
//			arrTemp[min] = arrTemp[out];
//			arrTemp[out] = temp;
			swap(min, out);
		}
		return arrTemp;
	}
	
	/**
	 * Insert Sort: 
	 * Advantage: twice fast than Bubble Sort, somewhat faster than select sort in normal situation
	 * Disadvantage: inverse arr will run no faster.
	 * 
	 *  O(N^2)
	 * 
	 * @param arr[]
	 * @return arr[]
	 */
	public static int[] insertSort(int[] arr){
		arrTemp = arr.clone();
		int len = arrTemp.length;
		int in, out;
		for(out=1; out<len; out++){
			int temp = arrTemp[out];
			in = out;
			while(in>0 && arrTemp[in-1] >= temp){
				arrTemp[in] = arrTemp[in-1];
				--in;
			}
			arrTemp[in] = temp;
		}
		return arrTemp;
	}
	
	/**
	 * Binary Insert Sort:
	 * when the length is LARGE, it will decrease the compare times
	 * 
	 * O(N^2)
	 * @param arr
	 * @return
	 */
	public static int[] binInsertSort(int[] arr){
		arrTemp = arr.clone();
		for (int i = 0; i < arrTemp.length; i++) {
            int temp = arrTemp[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<arrTemp[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
            	arrTemp[j+1] = arrTemp[j];
            }
            if(left != i){
            	arrTemp[left] = temp;
            }
        }
		return arrTemp;
	}
	
	/**
	 * Shell Sort:
	 * improve insert sort
	 * 
	 * O(nlogn)
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] shellSort(int[] arr){
		arrTemp = arr.clone();
		int dis = arrTemp.length;
		while(true){
			dis = dis/2;
			for(int x=0; x<dis; x++){
				for(int i=x+dis; i<arrTemp.length; i=i+dis){
					int temp = arrTemp[i];
					int j;
					for(j=i-dis; j>=0 && arrTemp[j]>temp; j=j-dis){
						arrTemp[j+dis] = arrTemp[j];
					}
					arrTemp[j+dis] = temp;
				}
			}
			if(dis == 1){
				break;
			}
		}
		return arrTemp;
	}
	
	/**
	 * Heap Sort
	 * 
	 * O(n log n)
	 * @param arr
	 * @return
	 */
	public static int[] heapSort(int[] arr){
		arrTemp = arr.clone();
		if(arrTemp == null || arrTemp.length <= 1){
			return arrTemp;
		}		
		buildMaxHeap(arrTemp);
		
		for(int i=arrTemp.length-1; i>=1; i--){
			swap(i, 0);
			maxHeap(arrTemp, i, 0);
		}
		
		return arrTemp;
	}
	
	private static void buildMaxHeap(int[] arr){
		if(arr == null || arr.length <= 1){
			return;
		}
		
		int half = arr.length /2;
		for(int i=half; i>=0; i--){
			maxHeap(arr, arrTemp.length, i);
		}
	}//a method of heap sort
	
	private static void maxHeap(int[] arr, int heapSize, int index){
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		
		 int largest = index;  
         if (left < heapSize && arrTemp[left] > arrTemp[index]) {  
             largest = left;  
         }  

         if (right < heapSize && arrTemp[right] > arrTemp[largest]) {  
             largest = right;  
         }  

         if (index != largest) {  
             swap(index, largest);
             maxHeap(arrTemp, heapSize, largest);  
         }  
	}// a method of heap sort
	
	
	/**
	 * Quick Sort 
	 * 
	 * O(n log n)
	 * 
	 * An Example of Quick Sort:
	 * 
	 *0--- 57  68  59  52  72  28  96  33  24  19
	 * 	   |ref                                 |
	 *1--- 19  68  59  52  72  28  96  33  24  57
	 *          |                               |
	 *2--- 19  57  59  52  72  28  96  33  24  68
	 *          |                           |
	 *3--- 19  24  59  52  72  28  96  33  57  68        
	 *              |                       |
	 *4--- 19  24  57  52  72  28  96  33  59  68
	 *              |                   |
	 *5--- 19  24  33  52  72  28  96  57  59  68
	 *                  |               |
	 *6--- 19  24  33  52  72  28  96  57  59  68  
	 *                      |           |
	 *7--- 19  24  33  52  57  28  96  72  59  68
	 *                      |   |
	 *8---[19  24  33  52  28] 57 [96  72  59  68]                      
	 *           part1                   part2
	 *                      
	 * @param arr
	 * @return
	 */
	public static int[] quickSort(int[] arr){
		arrTemp = arr.clone();
		if(arrTemp.length <= 1 || arrTemp == null){
			return arrTemp;
		}		
		divideArr4QuickSort(arrTemp, 0, arrTemp.length-1);
		return arrTemp;
	}
	
	private static void divideArr4QuickSort(int[] arr, int low, int high){
		if(low < high){
			int mid = getMiddle(arr, low, high);
			divideArr4QuickSort(arr,0,mid-1);
			divideArr4QuickSort(arr, mid+1, high);
		}
	}//a divide method of quick sort
	
	private static int getMiddle(int[] arr, int low, int high){
		int temp = arr[low];
		
		while(low < high){
			while(low < high && arr[high] >= temp){
				high--;
			}
			arr[low] = arr[high];
			while(low < high && arr[low] <= temp){
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = temp;
		
		return low;
	}//a method of quick sort
	
	
	/**
	 * Merge Sort:
	 * 
	 * O(n log n)
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] mergeSort(int[] arr){
		arrTemp = arr.clone();
		if(arrTemp.length <= 1 || arrTemp == null){
			return arrTemp;
		}
		
		divideArr4MergeSort(arrTemp, 0, arrTemp.length-1);
		
		return arrTemp;
	}
	
	
	private static void divideArr4MergeSort(int[] arr, int left, int right){
		if(left < right){
			int middle = (left + right)/2;
			divideArr4MergeSort(arr, left, middle);
			divideArr4MergeSort(arr, middle+1, right);
			merge(arr, left, middle, right);
		}
	}// a method of merge sort
	
	private static void merge(int[] arr, int left, int middle, int right){
		int[] tmpArr = new int[arr.length];
		int mid = middle + 1;
		int tmp = left;
		int third = left;
		
		while(left<=middle && right>=mid){
			if(arr[left]<=arr[mid]){
				tmpArr[third++] = arr[left++];
			}else {
				tmpArr[third++] = arr[mid++];
			}
		}
		
		while(left <= middle){
			tmpArr[third++] = arr[left++];
		}
		
		while(mid <= right){
			tmpArr[third++] = arr[mid++];
		}
		
		while(tmp <= right){
			arr[tmp] = tmpArr[tmp++];
		}
		
	}// a method of merge sort
	
	
	private static void swap(int index1, int index2){
		int temp = arrTemp[index1];
		arrTemp[index1] = arrTemp[index2];
		arrTemp[index2] = temp;
	}
		
}
