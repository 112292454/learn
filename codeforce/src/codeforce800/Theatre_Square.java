package codeforce800;

import java.util.Scanner;

public class Theatre_Square {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int r=in.nextInt();
		int l=in.nextInt();
		int a=in.nextInt();
		//long rs=r%a==0?r/a:r/a+1,ls=l%a==0?l/a:l/a+1;
		System.out.println((r%a==0?r/a:r/a+1)*(l%a==0?l/a:l/a+1));
	}
}
