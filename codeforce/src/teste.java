import java.util.Scanner;

public class teste {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String all=in.nextLine();
		System.out.print("f'(x)=");
		String[] str=all.split("");
		char re[]=new char[str.length ];
		for(int k=0;k<str.length;k++) {
			re[k]=str[k].charAt(0);
		}
		int xtimes=0;
		for (int i = 5; i < str.length; i++) {
			int a=1,n=1;
			if(re[i]=='x'&&re[i+1]=='^'&&i+1!=str.length) {
				xtimes++;
				String temp="";
				n=1;
				for (int j = i+2; j < str.length; j++) {
					if(!(re[j]=='+')&&(!(re[j]=='-'))) {
						temp+=re[j];
					}else {
						n=new Integer(temp).intValue();
						temp="";
						break;
					}
				}
				
				a=1;
				boolean flag=false;
				for (int j = i-1; j < str.length; j--) {
					
					if(flag&&(re[j]=='+'||re[j]=='=')) {
						a=new Integer(temp).intValue();
						break;
					}else if((!flag)&&re[j]=='+'||re[j]=='=') {
						break;
					}
					else if(flag&&re[j]=='-') {
						a=new Integer(temp).intValue();
						a=0-a;
						break;
					}else if((!flag)&&re[j]=='-') {
						a=-1;
						break;
					}else {
						temp=str[j]+temp;
						flag=true;
					}
				}
				
				a*=n;
				n--;
				if(xtimes!=1) System.out.print(a>0?"+":"");
				if(n!=1) System.out.print(a+"x^"+n);
				else System.out.print(a+"x");
			}else if(str[i].equals("x")&&!str[i+1].equals("^")||(i+1==str.length&&str[i].equals("x"))) {
				xtimes++;
				
				String temp="";
				boolean flag=false;
				for (int j = i-1; j < str.length; j--) {
					if(flag&&re[j]=='+'||re[j]=='=') {
						a=new Integer(temp).intValue();
						break;
					}else if((!flag)&&(re[j]=='+'||re[j]=='=')) {
						break;
					}
					else if(flag&&re[j]=='-') {
						a=new Integer(temp).intValue();
						a=0-a;
						break;
					}else if((!flag)&&re[j]=='-') {
						a=-1;
						break;
					}else {
						temp=str[j]+temp;
						flag=true;
					}
				}
				
				if(xtimes!=1) System.out.print(a>0?"+":"");
				System.out.print(a);
			}
		}
	}
}
