package codeforce800;

import java.util.Scanner;
/*
 * 如果每列和为1——必为10——计2——分割
 * 和为0——00——计1，仅当后面是2，合并
 * 和为2——11——计0，仅当后面是0，合并
 * 最多合并两列，第三列必分割
 * */
public class Max_Mex {
	static int mex(int i,int j) {
		if(i+j==2) return 0;
		else return i+j+1;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int times=in.nextInt();
		for (int i=1;i<=times;i++) {
			int length=in.nextInt();
			in.nextLine();
			int sum=0;
			char[] up=in.nextLine().toCharArray();
			char[] down=in.nextLine().toCharArray();
			for(int j=0;j<=length-1;) {
				int mex=mex((int)up[j]-48,(int)down[j]-48);
				if(j==length-1) {
					sum+=mex;
					break;
				}
				if(mex==2) {
					sum+=2;
					j++;
				}else if(mex==1){
					if((int)up[j+1]-48+(int)down[j+1]-48==2) {
						sum+=2;
						j+=2;
					}else {
						sum++;
						j++;
					}
				}else {
					if((int)up[j+1]-48+(int)down[j+1]-48==0) {
						sum+=2;
						j+=2;
					}else j++;
				}
			}
			System.out.println(sum);
		}
	}
}
