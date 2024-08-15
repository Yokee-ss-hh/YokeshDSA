package org.dsa.bitmanipulation;

public class BitSet {
	// set, clear, toggle 
	private static int setKthBit(int num, int pos) {
		return (num | (1 << pos));
	}
	private static int unSetKthBit(int num, int pos) {
		return (num & ~(1 << pos));
	}
	private static int toggleKthBit(int num, int pos) {
		return (num ^ (1 << pos));
	}
	public static void main(String[] args) {
		System.out.println(setKthBit(5, 1)); // Sets 2nd bit 
		System.out.println(unSetKthBit(7, 0)); // Un set 1st bit , also called as "clear"
		System.out.println(toggleKthBit(7, 2)); // toggles 2nd bit 
	}
}
