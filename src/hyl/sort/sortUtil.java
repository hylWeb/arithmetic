package hyl.sort;

import java.util.Random;

public class sortUtil {

	public static void Swap(int A[], int i, int j)
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
}
