package com.arnav.ds;

public class IterativeFibonacci {

	public static void main(String s[]){
		
		int x = 0;
		int y = 1;
		int r = 40;
		int sum = 0;
		long startMillis = System.currentTimeMillis();
		System.out.println();
		System.out.print("fabonacci series is: 0 1");
		for(int i = 3; i<=r; i++){
			sum = x+y;
			x = y;
			y = sum;
			System.out.print(" "+sum);
		}
		long endMillis = System.currentTimeMillis();
		System.out.println();
		System.out.println("Total time taken: "+(endMillis-startMillis)+" ms");
		
	}
}
