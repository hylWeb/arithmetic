package hyl.sort;

import java.util.Arrays;

import org.junit.Test;

import hyl.util.MethodExecuteTimeUtils;
import hyl.util.SortUtil;

public class SortTest {

	@Test
	public void testquick(){
		int len = 19;
		int[] arr = SortUtil.getRandomArr(len, 0, 100);
		//int[] arr = {3, 49, 9, 78, 9, 91, 13, 22, 12, 22};
		System.out.println(Arrays.toString(arr));
		SortMethod.quickSort(arr, 0, len-1);
		System.out.println("最后："+Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int len = 5000;
		Object clazz = SortMethod.class;
		int[] arr = SortUtil.getRandomArr(len, 10, 1000000);
		//int[] arr = SortUtil.getNearySortArr(len, 10);
		int[] arr1 = Arrays.copyOf(arr, len);
		int[] arr2 = Arrays.copyOf(arr, len);
		int[] arr3 = Arrays.copyOf(arr, len);
		int[] arr4 = Arrays.copyOf(arr, len);
		int[] arr5 = Arrays.copyOf(arr, len);
	    try {
	    	MethodExecuteTimeUtils.getMethodExecuteTime(clazz, new Object[]{arr}, "javaSort", new Class<?>[]{int[].class}, true);
	    	MethodExecuteTimeUtils.getMethodExecuteTime(clazz, new Object[]{arr1,0,len-1}, "mergeSort", new Class<?>[]{int[].class,int.class,int.class},true);
			MethodExecuteTimeUtils.getMethodExecuteTime(clazz,new Object[]{arr2}, "insertSort", new Class<?>[]{int[].class},true);
			MethodExecuteTimeUtils.getMethodExecuteTime(clazz,new Object[]{arr3}, "selectSort", new Class<?>[]{int[].class},true);
			MethodExecuteTimeUtils.getMethodExecuteTime(clazz,new Object[]{arr4}, "bubbleSort", new Class<?>[]{int[].class},true);
			MethodExecuteTimeUtils.getMethodExecuteTime(clazz, new Object[]{arr5,0,len-1}, "quickSort", new Class<?>[]{int[].class,int.class,int.class},true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
