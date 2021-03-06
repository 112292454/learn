package pat;

import java.util.*;

public class B1005 {
	static void callatz(int i,HashMap even) {
		if(even.containsKey(i)) return;
		if(i%2==0&&i!=1) callatz(i/2, even);
		else if(i%2==1&&i!=1) callatz((3*i+1)/2, even);
		even.putIfAbsent(i, 1);
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int times=in.nextInt();
		int[] simple=new int[times];
		int[] odd=new int[times];
		int j=0;
		final HashMap<Integer, Integer> even =new HashMap<Integer, Integer>();
		for (int i = 0; i < simple.length; i++) simple[i]=in.nextInt();
		for (int i = 0; i < simple.length; i++) {
			if(even.containsKey(simple[i])) continue;
			callatz(i%2==0?simple[i]/2:(3*simple[i]+1)/2, even);
		}
		for (int i = 0; i < times; i++) {
			if(!even.containsKey(simple[i])) odd[i]=simple[i];
		}
		Arrays.sort(odd);
		for (int i = odd.length-1; i >=1&&odd[i]!=0; i--) {
			System.out.print(odd[i]);
			if(odd[i-1]!=0) System.out.print(" ");
		}
	}
}
