package codeforce800;

import java.util.Scanner;

public class Seating_Arrangements {
	//unsolved
	int getbig (int i,int[] arr) {
		int times=0;
		for(int j:arr) if(j>i) times++;
		return times;
	}
	
	int same(int i,int[] arr) {
		int times=0;
		for(int j:arr) if(j==i) times++;
		return times;
	}
	
	static int obstacles(int i,int lines,int arr[]) {
		int rows=i%lines==0?i/lines:i/lines+1;
		int obstacle=0;
		for (int j = (rows-1)*lines; j<i-1; j++) {
			obstacle+=arr[j]==0?0:1;
		}
		return obstacle;
	}
	
	public static void main(String args[]) {
		int rows,lines,result;
		Scanner in=new Scanner(System.in);
		int times=in.nextInt();
		for (int i=1;i<=times;i++) {
			rows=in.nextInt();
			lines=in.nextInt();
			int all[]=new int[rows*lines];
			in.nextLine();
			String str[]=in.nextLine().split(" ");
			int[] contents=new int[str.length];
			int[] results=new int[str.length];
			int[] now=new int[str.length];
			for(int j=0;j<str.length;j++) {
				contents[j]=Integer.parseInt(str[j]);
			}
			Seating_Arrangements quest=new Seating_Arrangements();
			for (int j = 0; j < results.length; j++) {
			int big=quest.getbig(contents[j], contents);
			for (int k = 0; k < quest.same(contents[j], contents); k++) {
					if(now[now.length-big-1-k]==0) {
						now[now.length-big-1-k]=1;
						results[results.length-big-1-k]=obstacles(now.length-big-k,lines,now);
						break;
					}else continue;
				}
			}//ÒÑµÃµ½result
			result=0;
			for(int i1:results) {
				result+=i1;
			}
			System.out.println(result);
		}
	}
}
