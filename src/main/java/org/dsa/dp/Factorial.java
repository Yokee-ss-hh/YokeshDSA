package org.dsa.dp;

public class Factorial {
   
	private static int factTopDown(int num) {
		if(num <= 1) {
			return num; // factToDown(0) never be called since f(1) call will not split further into sub-problem. So, It doesn't matter if we return "num" / 1 
		}
		return num*factTopDown(num-1);
	}
	private static int factBottomTop(int num) {
		if(num <= 1) {
			return 1;
		}
		else {
			int[] arr = new int[num+1];
			arr[0] = 1;
			arr[1] = 1;
			for(int i=2;i<=num;i++) {
				arr[i] = i*arr[i-1];
			}
			return arr[num];
		}
	}
	public static void main(String[] args) {
		System.out.println(factTopDown(3));
		System.out.println(factBottomTop(3));
	}

}