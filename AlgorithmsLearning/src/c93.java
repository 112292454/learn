import java.util.Random;
public class c93 {
	//天书贴图所得连线数的概率测试
	Random r=new Random();
	static int times=0;//单次的连线数
	static int result[]=new int[4];//结果
	static int line1[]=new int[4];
	static int line2[]=new int[4];
	static int[][] a=new int [4][4];//贴图表格，4*4
	public void getAll() {
		int time=0;
		int i=0;
		int j=0;
		do {
			i=r.nextInt(4);
			j=r.nextInt(4);
			if (a[i][j]!=0) continue;
			else {
				a[i][j]=1;
				time+=1;
			}
		} while (time<9);//模拟贴上9个图案
		for (int count1=0;count1<=3;count1++) line1[count1]=a[count1][count1 ];
		line2[0]=a[0][3];
		line2[1]=a[1][2];
		line2[2]=a[2][1];
		line2[3]=a[3][0];//将对角线存为两个数组，以便判断
	}
	private void check(int a[]) {
		for(int i=0;i<=3;i++) {
			if (a[i]!=1) return;//如果不全部贴上图（为1）则直接结束方法，否则连线数+1
		}
		times++;
	}
	private void set(int i) {//根据某一次的连线数设置最终的结果数组
		switch (i) {
		case 0:
			result[0]++;
			break;
		case 1:
			result[1]++;
			break;
		case 2:
			result[2]++;
			break;
		case 3:
			result[3]++;
			break;
		}
	}
	private void reset() {
		
	}
	public static void main(String args[]) {
		for(int i=0;i<1000000;i++) {
			c93 c=new c93();
			c.getAll();
			c.check(line1);
			c.check(line2);//生成贴图，检查对角线
			for(int j=0;j<=3;j++) {
				c.check(a[j]);//检查行
				int line[]=new int[4];
				for (int k=0;k<=3;k++) {
					line[k]=a[k][j];//将列分别存储为数组，二维数组无法直接选中某列
				}
				c.check(line);//检查列
			}
			c.set(times);
			times=0;
			a=new int[4][4];//重置贴图表格
		}//结束，输出
		System.out.print("共测试一百万次，天书无连线概率"+(double)result[0]/1000000+",1线概率"+(double)result[1]/1000000+"，2线概率"+(double)result[2]/1000000+"，3线概率"+(double)result[3]/1000000);
	}
}
