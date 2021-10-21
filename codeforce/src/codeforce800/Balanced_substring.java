package codeforce800;


import java.util.Scanner;

public class Balanced_substring {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int times=in.nextInt();
		String s;
		for (int i=1;i<=times;i++) {
			int length=in.nextInt();
			in.nextLine();
			s=in.nextLine();
			//in.nextLine();
			if (length==1) {
				System.out.println("-1 -1");
				continue;
			}
			char[] single=s.toCharArray();
			boolean has=false;
			for(int j=0;j<single.length-1;j++) {
				if (single[j]!=single[j+1]) {
					System.out.println((j+1)+" "+(j+2));
					has=true;
					break;
				}
			}
			if(!has) System.out.println("-1 -1");
		}
		in.close();
	}
}

