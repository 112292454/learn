package codeforce800;

import java.util.Scanner;
/*
 * ���ÿ�к�Ϊ1������Ϊ10������2�����ָ�
 * ��Ϊ0����00������1������������2���ϲ�
 * ��Ϊ2����11������0������������0���ϲ�
 * ���ϲ����У������бطָ�
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
