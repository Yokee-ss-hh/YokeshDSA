package org.dsa.permutations;

import java.util.Arrays;

public class Permutations {
	private static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
    private static void permutations(int[] array, int index, int end) {
    	if(index == end) {
    		System.out.println(Arrays.toString(array));
    	}
    	for(int i=index;i<array.length;i++) {
    		swap(array,i,index);
    		permutations(array, index+1, end);
    		swap(array,i,index);
    	}
    }
	public static void main(String[] args) {
	     permutations(new int[] {1,2,3}, 0, 3);	
	}
}
