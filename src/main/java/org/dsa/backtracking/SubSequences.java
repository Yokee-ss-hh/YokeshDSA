package org.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequences{
	private static void getSubSequences1(int[] array, int index, List<Integer> temp){
		if(index >= array.length) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
		else {
			temp.add(array[index]);
			getSubSequences1(array, index+1, temp);
			temp.remove(temp.size()-1);
			getSubSequences1(array, index+1, temp);
		}
	}
	private static void getSubSequences2(int[] array, int index, List<Integer> temp) {
		System.out.println(Arrays.toString(temp.toArray()));	
		for(int i=index;i<array.length;i++) {
			temp.add(array[i]);
			getSubSequences2(array, i+1, temp);
			temp.remove(temp.size()-1);
		}
	}
	private static void getUniqueSubSets(int[] array, int index, List<Integer> temp) {
		System.out.println(Arrays.toString(temp.toArray()));
		for(int i=index;i<array.length;i++) {
			if(i != index && array[i] == array[i-1]) {
				continue;
			}
			temp.add(array[i]);
			getUniqueSubSets(array,i+1,temp);
			temp.remove(temp.size()-1);
		}
	}
	// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates 
	// where the chosen numbers sum to target. You may return the combinations in any order.
	// The same number may be chosen from candidates an unlimited number of times.
	private static void combinationSum1(int[] array,int index, int sum, List<Integer> temp) {
		if(sum == 0) {
			System.out.println(Arrays.toString(temp.toArray()));	
		}
		for(int i=index;i<array.length;i++) {
			temp.add(array[i]);
			if(array[i] <sum) {
				combinationSum1(array, i, sum-array[i], temp);
			}
			else {
				combinationSum1(array, i+1, sum-array[i], temp);
			}
			temp.remove(temp.size()-1);
		}
	}
	// Given a collection of candidate numbers (candidates) and a target number (target)
	// find all unique combinations in candidates where the candidate numbers sum to target.
    // Each number in candidates may only be used once in the combination.
	// The array can contain duplicates
	private static void combinationSum2(int[] array, int index, int sum, List<Integer> temp) {
		if(sum == 0) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
		for(int i=index;i<array.length;i++) {
			if(i != index && array[i] == array[i-1]) {
				continue;
			}
			temp.add(array[i]);
			combinationSum2(array, i+1, sum-array[i], temp);
			temp.remove(temp.size()-1);
		}
	}
	// This is combination sum 2 problem of subsequence of size 'k'
	private static void combinationSum3(int[] array, int index, int size, int sum, List<Integer> temp) {
		if(sum == 0 && temp.size() == size) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
		for(int i=index;i<array.length;i++) {
			if(i != index && array[i]==array[i-1]) {
				continue;
			}
			temp.add(array[i]);
			combinationSum3(array, i+1, size,sum-array[i], temp);
			temp.remove(temp.size()-1);
		}
	}
	private static void powerSet(int[] array) { 
		// This takes n*(2 power n) TC & O(1) SC. Better go with backtracking which takes TC as O(2 power n) and SC as O(2 power n)
		int len = array.length;
		for(int i=0;i<Math.pow(2, len);i++) {
			for(int j=0;j<len;j++) {
				if((i & (1 << j)) > 0) {
					System.out.print(array[j]);
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getSubSequences1(new int[] {1,2,3},0,new ArrayList<Integer>());
		System.out.println("---------");
		getSubSequences2(new int[] {1,2,3},0,new ArrayList<Integer>());
		System.out.println("---------");
		getUniqueSubSets(new int[] {1,1,3},0,new ArrayList<Integer>());
		System.out.println("---------");
		combinationSum1(new int[] {2,3,6,7},0,7,new ArrayList<Integer>());
		System.out.println("---------");
		combinationSum2(new int[] {1,2,3},0,3,new ArrayList<Integer>());
		System.out.println("---------");
		combinationSum3(new int[] {1,2,3,4,5,6,7,8,9},0,3,7,new ArrayList<Integer>());
		System.out.println("-----------");
		powerSet(new int[] {1,2,3});
	}
}