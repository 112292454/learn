package codeforce800;

import java.util.Scanner;

public class Swaps {
	//TLE,O(n2)²»¿ÉÐÐ£¿
	public static int times(int i,int[] arr) {
		int j=0;
		for (j=0; j < arr.length; j++) {
			if(arr[j]>i) return j;
		}
		return j;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int times=in.nextInt();
		for (int i=1;i<=times;i++) {
			int leng=in.nextInt();
			int[] odd = new int[leng],even=new int[leng];
			for (int j = 0; j < leng; j++) {
				odd[j]=in.nextInt();
			}
			int result=0;
			for (int j = 0; j < leng; j++) {
				even[j]=in.nextInt();
			
			result=times(odd[0],even);
				int t=times(odd[j],even)+j;
				if (t<result) {
					result=t;
				}
				
			}
			
			System.out.println(result);
			
		}
	}
}
