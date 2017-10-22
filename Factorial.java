package com.arnav.ds;
public class Factorial {
	protected void xx(){
		System.out.println("Factorial.xx()");
	}
	public static void main(String s[]){
		int n = 6;
		int fac = 1;
		for(int i = 1; i<=n;i++){
			fac*=i; 
		}
		System.out.println("Factorial of "+n +" using iteration is: "+fac);
		System.out.println("Factorial of "+n +" using recursion is: "+factorial(n));
	}
	public static int factorial(int n){		
		if(n==1){
			return 1;
		}
		return n*factorial(n-1);
	} 
}
