package com.arnav.ds;

public enum Numbers{
	one(1),two(2), three(3),four(4), five(5),six(6),seven(7),eight(8),nine(9),ten(10), negOne(-1), negTwo(-2), 
	negThree(-3), negFour(-4), negFive(-5), negSix(-6), negSeven(-7), negEight(-8), negNine(-9), negTen(-10);
	public int val;
	Numbers(int n){
		this.val = n;
	}
	public static Numbers getNumber(String n){
		Numbers num;
		try{
			num = Numbers.valueOf(n);
		}catch(Exception e){
			num = null;
		}
		return num;
	}
}