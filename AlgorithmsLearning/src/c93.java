import java.util.Random;
public class c93 {
	//������ͼ�����������ĸ��ʲ���
	Random r=new Random();
	static int times=0;//���ε�������
	static int result[]=new int[4];//���
	static int line1[]=new int[4];
	static int line2[]=new int[4];
	static int[][] a=new int [4][4];//��ͼ���4*4
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
		} while (time<9);//ģ������9��ͼ��
		for (int count1=0;count1<=3;count1++) line1[count1]=a[count1][count1 ];
		line2[0]=a[0][3];
		line2[1]=a[1][2];
		line2[2]=a[2][1];
		line2[3]=a[3][0];//���Խ��ߴ�Ϊ�������飬�Ա��ж�
	}
	private void check(int a[]) {
		for(int i=0;i<=3;i++) {
			if (a[i]!=1) return;//�����ȫ������ͼ��Ϊ1����ֱ�ӽ�������������������+1
		}
		times++;
	}
	private void set(int i) {//����ĳһ�ε��������������յĽ������
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
			c.check(line2);//������ͼ�����Խ���
			for(int j=0;j<=3;j++) {
				c.check(a[j]);//�����
				int line[]=new int[4];
				for (int k=0;k<=3;k++) {
					line[k]=a[k][j];//���зֱ�洢Ϊ���飬��ά�����޷�ֱ��ѡ��ĳ��
				}
				c.check(line);//�����
			}
			c.set(times);
			times=0;
			a=new int[4][4];//������ͼ���
		}//���������
		System.out.print("������һ����Σ����������߸���"+(double)result[0]/1000000+",1�߸���"+(double)result[1]/1000000+"��2�߸���"+(double)result[2]/1000000+"��3�߸���"+(double)result[3]/1000000);
	}
}
