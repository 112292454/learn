package basic;

public class MaxHeap {
	public static void main(String args[]) {
		
	}
	//���¼򵥷���������˼�弴��
	public int GetLeft(int i){
		return 2*i;
	}
	public int GetRight(int i){
		return 2*i+1;
	}
	public long GetLeft(long i){
		return 2*i;
	}
	public long GetRight(long i){
		return 2*i+1;
	}
	public void Exchange(int i,int j) {
		int temp=i;
		i=j;
		j=temp;
	}
	//
	
	//ά�����������ѣ�����������
	public int[] MaxHeapify(int[] A,int i) {
		//��i�ڵ�������������Ϊ����ʱʹ�ã��ɽ�i������������һ�����ѣ�����Ӧʹ��build����(������һ��λ�ô����A[i]ʱ)
		int R=GetRight(i);
		int L=GetLeft(i);
		int largest=i;
		if(A[R]>=A[i]) largest=R;
		else if(A[L]>=A[i]) largest=L;
		if(largest!=i) {
			Exchange(A[largest], A[i]);
			MaxHeapify(A,largest);
		}
		return A;
	}
	public int[] BuildMaxHeap(int[] A) {
		//ʹһ������������Ϊ����
		for(int i=A.length;i>1;i--) MaxHeapify(A,i);
		return A;
	}
	public int[] HeapUpSort(int[] A) {
		//��������ʵ�ֶ������������������
		BuildMaxHeap(A);
		int i=A.length;
		do {
			Exchange(A[i], A[1]);
			i--;
			MaxHeapify(A,1);
		} while (i>=2);
		return A;
	}
	//
	
}
