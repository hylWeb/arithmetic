package hyl.sort;

import java.util.Arrays;
import java.util.Random;

import hyl.util.SortUtil;

public class SortMethod {
	private static Random r = new Random();
	
	public static int[] javaSort(int[] arr){
		int aa[] = arr;
		Arrays.sort(aa);
		return aa;
	}
	/**
	 * 插入排序，由第二个开始与前一个比较，如果比前一个小
	 * 将当前位置赋值为前一个，直到找到自己的位置
	 * @param arr
	 * @return
	 */
	public static int[] insertSort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int a = arr[i]; //这个是要插入的元素
			int j; //a应该插入的位置
			for (j = i; j > 0; j--) {
				if(a < arr[j-1]){  //a和j前面的位置一一比较。如果a小，则一一向后赋值
					arr[j] = arr[j-1]; 
				}else {
					break;  //否则不变，直接跳出循环 赋值
				}
			}
			arr[j] = a;  //插入到正确的位置
		}
		return arr; 
	}

	/**
	 * 基本的冒泡  ，相邻两两对比
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr){

		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]){
					SortUtil.swap(arr, j, j+1);
				}
			}
		}
		return arr; 
	}
	/**
	 * 选择排序，找出最小值，排序
	 * @param arr
	 * @return
	 */
	public static int[]  selectSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			int min = i;//最小值下标
			for (int j = i; j < arr.length; j++) {
				if(arr[min] > arr[j]){  //找出最小值的下标
					min = j;    
				}
			}
			if (min != i)
			{
				SortUtil.swap(arr, min, i);    // 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
			}
		}
		return arr; 
	}

	/**
	 * 归并排序，拆分为最小的，排序后合并
	 * @param arr
	 * @return
	 */
	public static int[] mergeSort(int[] arr,int low,int high){

		int mid = (low + high) / 2;
		if (low < high) {  
			// 左边  
			mergeSort(arr, low, mid);  
			// 右边  
			mergeSort(arr, mid + 1, high);  
			// 左右归并  
			if(arr[mid] > arr[mid+1] )
				mergeSortImpl(arr, low, mid, high);  

		}  
		return arr;  
	}
	/**
	 * 合并操作
	 * @param arr 原数组
	 * @param low 左边下标
	 * @param mid  中间下标
	 * @param high 右边下标
	 */
	private static void mergeSortImpl(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];  
		int i = low;// 左指针  
		int j = mid + 1;// 右指针  
		int k = 0;
		// 把较小的数先移到新数组中   
		while (i <= mid && j <= high) {  
			if (arr[i] < arr[j]) {  
				temp[k++] = arr[i++];  
			} else {  
				temp[k++] = arr[j++];  
			}  
		}  
		//可能剩下的左边
		while(i <= mid){
			temp[k++] = arr[i++];
		}
		//也可能剩下的右边
		while(j <= high){
			temp[k++] = arr[j++];
		}
		// 把新数组中的数覆盖arr数组  
		for (int k2 = 0; k2 < temp.length; k2++) {  
			arr[k2 + low] = temp[k2];  
		}  
	}
	
	/**
	 * 快速排序 以一个值为基准，找到自己的位置，左边小于自己，右边大于自己
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] quickSort(int[] arr,int low,int high){
		
		if(high > low){
			int mid = findIndex(arr,low,high);
			quickSort(arr,low,mid);
			quickSort(arr,mid+1,high);
		}
		
		return arr;
	}
	private static int findIndex(int[] arr, int low, int high) {
		SortUtil.swap(arr,low,r.nextInt(high) % (high-low +1) +low);  //让第一个值和数组里任意数交换
		int v = arr[low];
		int key = low;//返回的位置
		for (int i = low+1; i <= high; i++) {
			if(arr[i] < v ){
				SortUtil.swap(arr, i, key);
				key++;  //只有前面的值比key大，交换位置，并把key+!
				System.out.println(Arrays.toString(arr));
			}
		}
		
		return key;
	}
	
}
