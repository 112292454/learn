package codeforce800;

import java.util.Scanner;

public class Lifting_Stones {
	//WA
	static long stones=0;
	static long result(long i) {
		int j=0;
		for(j=1;;j*=2) {
			if(j>i) {
				i-=j/2;
				break;
			}else if(j==i) {
				i=0;
				break;
			}
		}
		if(i>=1) {
			stones++;
			result(i);
		}else {
			stones++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int i=in.nextInt();
		result((long)i);
		System.out.println(stones);
		in.close();
	}
}
