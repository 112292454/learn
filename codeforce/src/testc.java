import java.util.Arrays;
import java.util.Scanner;

public class testc {
	
	static long split(long l,long r,String s) {//获取划分点
		if (r-l>1) {
			s+=" "+(r+l)/2;
		return split(l, (l+r)/2, s)+split((l+r)/2+1,r,s);
		}else return 0;
	}
	long getw(long l,long r,long[] sp) {//获取对（l，r）的w
		int i,j;
		for(i=0;i<=sp.length;i++) {
			if(l<=sp[i]) break;
		}
		for(j=sp.length-1;j>=0;j--) {
			if(r>=sp[i]) break;
		}
		if (j<=i) return 1;
		return j-i+2;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int times=in.nextInt();
		for(int i=0;i<=times;i++) {
			int n=in.nextInt();
			String split="";
			split(1,n,split);
			String[] sp=split.split(" ");
			long[] result=new long[n];
			int i1=0;
			for(String s:sp) {
				result[i1]=new Long(s).longValue();
				i1++;
			}
			Arrays.sort(result);
			//获取划分点结束
			long l=in.nextLong();
			long r=in.nextLong();
			long simplew=in.nextLong();
			//读入完成
			long w[]=new long[n];
			
			//还需对所有满足条件的（l,r）计算w，与给的k比较，确定最短的l，r
			
		}
	}
}
