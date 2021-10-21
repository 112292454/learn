package pat;
import java.util.Scanner;

public class B1029 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] result=new int[127];
		char[] ch1=in.nextLine().toCharArray();
		char[] ch2=in.nextLine().toCharArray();
		for (int i = 0,j=0; i < ch1.length;) {
			if(Character.toUpperCase(ch1[i])==Character.toUpperCase(ch2[j])){
				i++;
				if(j<ch2.length-1) {j++;}
			}else{
				if(result[Character.toUpperCase(ch1[i])]==0){
					result[Character.toUpperCase(ch1[i])]++;
					System.out.print(Character.toUpperCase(ch1[i]));
				}
				i++;
			}
		}
	}
}
