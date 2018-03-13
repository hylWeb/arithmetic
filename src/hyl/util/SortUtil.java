package hyl.util;

import java.util.Random;

public class SortUtil {

	public static void swap(int A[], int i, int j)
	{
	    int temp = A[i];
	    A[i] = A[j];
	    A[j] = temp;
	}
	
	public static int[] getRandomArr(int n,int min,int max){
		
		int[] arr = new int[n];
		Random r=  new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(max) % (max-min) + min+1;  
		}
		return arr;
	}
	
	public static int[] getNearySortArr(int n,int diff){
		
		int[] arr = new int[n];
		Random r=  new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = i;  
		}
		for (int i = 0; i < diff; i++) {
			int x = r.nextInt(n);
			int y = r.nextInt(n);
			swap(arr,x,y);
		}
		return arr;
	}
	
	
}
