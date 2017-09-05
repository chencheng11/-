/**
 * 基于堆的优先队列
 * 很多情况下并不一定要求所有的元素都是有序的，只需要处理数组的最大值或者是最小值，在这种情况下优先队里就出来了。
 * 数据结构二叉树能够很好的实现优先队列的基本操作。在二叉堆中，每个节点都小于或者是等于他的父节点。这样包拯根节点是最大的节点。
 * 我们也可以使用堆的有限队列进行，而且这种排序的时间复杂度也是最优化的NlogN；
 */
public class MaxPQ<key extends Comparable<key>> {
	private key[] pq;
	private int N=0;
	public MaxPQ(int maxN){
		pq=(key[]) new Comparable[maxN+1];
	}

	public void insert(key v){
		pq[++N]=v;
		swim(N);
	}
	private void swim(int k) {
		//由下至上的堆有序化（上浮）的实现
		while(k>1&&less(pq[k/2],pq[k])){
			exch(k/2,k);
			k=k/2;
		}
		 
	}
	private boolean less(key key, key key2) {
	 return key.compareTo(key2)<0;
	}

	public key delMax(){
		key max=pq[1];
		exch(1,N--);
		pq[N+1]=null;
		sink(1);
		return max;
		
	}
	private void sink(int k) {
		while(2*k<N){
			//由下至上的堆有序化（下沉）的实现
			int j=2*k;
			if(less(pq[j],pq[j+1])) j++;
			if(less(pq[j],pq[k])) exch(j,k);
			k=j;
		}
	}
	private void exch(int i, int j) {
	
		key m=pq[i];
		pq[i]=pq[j];
		pq[j]=m;
	}	
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
}
