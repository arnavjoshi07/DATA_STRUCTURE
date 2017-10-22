package com.arnav.ds;

public class RecursiveFibonacci {
	static int fibonacci(int n){
		if(n<2){
			return n;
		}
		return fibonacci(n-1)+fibonacci(n-2);			
	}
	public static void main(String s[]){
		long startMillis = System.currentTimeMillis();
		System.out.print("fabonacci series is:");
		int n = 40;
		for(int i = 0; i<=n; i++){
			System.out.print(" "+fibonacci(i));	
		}
		long endMillis = System.currentTimeMillis();
		System.out.println();
		System.out.println("Total time taken: "+(endMillis-startMillis)+" ms");
		
	}
}
