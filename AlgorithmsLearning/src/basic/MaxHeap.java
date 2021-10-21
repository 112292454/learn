package basic;

public class MaxHeap {
	public static void main(String args[]) {
		
	}
	//以下简单方法，顾名思义即可
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
	
	//维护；构造最大堆；利用其排序
	public int[] MaxHeapify(int[] A,int i) {
		//当i节点下两个子树均为最大堆时使用，可将i及其子树变完一个最大堆，否则应使用build方法(即仅有一个位置错误的A[i]时)
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
		//使一个无序的数组变为最大堆
		for(int i=A.length;i>1;i--) MaxHeapify(A,i);
		return A;
	}
	public int[] HeapUpSort(int[] A) {
		//利用最大堆实现对无序数组的升序化排列
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
