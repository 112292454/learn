package codeforce800;

import java.util.Arrays;
import java.util.Scanner;

public class Slay_the_Dragon {
	public static int attack(long dragonh,long[] hero) {
		for (int i = hero.length-1; i>=0; i--) {
			if(hero[hero.length-1]<dragonh) {
				return -1;
			}else if(hero[i]>=dragonh) {
				continue;
			}else {
				return i+1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int hs=in.nextInt();
		long[] hero=new long[hs];
		for(int i=0;i<hs;i++) {
			hero[i]=in.nextLong();
		}
		int ds=in.nextInt();
		long[] result=new long[ds];
		long[] dragona=new long[ds];
		long[] dragonh=new long[ds];
		for(int i=0;i<ds;i++) {
			dragonh[i]=in.nextLong();//health____one people
			dragona[i]=in.nextLong();//attack______all other people
		}
		//¶ÁÈëÍê³É
		Arrays.sort(hero);
		for (int i = 0; i <= ds-1; i++) {
			int who=attack(dragonh[i],hero);
			long[] herotemp=hero.clone();
			long hsum=0;
			for(long l:herotemp) {
				hsum+=l;
			}
			if(who==-1) {
				result[i]+=dragonh[i]-herotemp[herotemp.length-1];
				herotemp[hero.length-1]=0;
				hsum-=hero[hero.length-1];
			}else if(who==0) {
				herotemp[0]=0;
				hsum-=hero[0];
			}else {
				int whos=-1,j=0;
				while(hero[j]<hero[who]) {
					j++;
					whos++;
				}
				if(hero[who]-hero[whos]>dragonh[i]-hero[whos]&&hsum-hero[who]<dragona[i]) {
					result[i]+=dragonh[i]-hero[whos];
					hsum-=hero[whos];
					herotemp[whos]=0;
				}else {
					//result[i]+=hero[who]-dragonh[i];
					hsum-=hero[who];
					herotemp[who]=0;
				}
			}
			result[i]+=hsum>=dragona[i]?0:dragona[i]-hsum;
		}
		for(long l:result) {
		System.out.println(l);
		}
	}
}
