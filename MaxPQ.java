/**
 * ���ڶѵ����ȶ���
 * �ܶ�����²���һ��Ҫ�����е�Ԫ�ض�������ģ�ֻ��Ҫ������������ֵ��������Сֵ����������������ȶ���ͳ����ˡ�
 * ���ݽṹ�������ܹ��ܺõ�ʵ�����ȶ��еĻ����������ڶ�����У�ÿ���ڵ㶼С�ڻ����ǵ������ĸ��ڵ㡣�����������ڵ������Ľڵ㡣
 * ����Ҳ����ʹ�öѵ����޶��н��У��������������ʱ�临�Ӷ�Ҳ�����Ż���NlogN��
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
		//�������ϵĶ����򻯣��ϸ�����ʵ��
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
			//�������ϵĶ����򻯣��³�����ʵ��
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
