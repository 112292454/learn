package pat;

import java.util.Scanner;

public class B1038 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] stu=new int[in.nextInt()];
		int[] grades=new int[100];
		for (int i = 0; i < stu.length; i++) {
			stu[i]=in.nextInt();
		}
		for (int i:stu) {
			grades[i]++;
		}
		int res=in.nextInt();
		for (int i = 1; i <= res; i++) {
			System.out.print(grades[in.nextInt()]);
			if(i!=res) System.out.print(" ");
		}
	}
}
