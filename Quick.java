/**
 * ��������
 * ��������ʵ�ּ򵥡�ԭ�����������ڸ��ֲ�ͬ���������ݶ��ұ�����������Ҫ���ӿ��٣�������Ӧ����㷺�������㷨��
 *  ��������ʱ�临�Ӷ�ΪNlogN ���ҿռ临�Ӷ�Ҳ��С��
 *  �㷨�Ľ���
 *  1������С�����������ȿ��������ٶȸ���
 *  2����ʵ��Ӧ���л�����ܶ��ظ���Ԫ�أ��ڴ˾Ϳ���ʹ�������зֿ��������㷨��������ָ���ӦС�ڡ����ڡ����ڡ�
 */
public class Quick {
	public static void sort(Comparable[] a){
		sort(a,0,a.length);
	}
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo>=hi) return ;
		int j=partition(a,lo,hi);
	}
	private static int partition(Comparable[] a, int lo, int hi) {
		//��loΪ���������з֣� ʹi�����С��a[lo] �ұߴ���a[lo]
		Comparable v=a[lo];
		int i=lo,j=hi+1;
		while(true){
			while(less(a[i],v)) if(i==hi) break;
			while(less(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
					}
		exch(a,lo,i);
		return i;
	}
	private static void exch(Comparable[] a, int i, int j) {
		//��������a�е�i��j��λ��
		Comparable m=a[j];
		a[j]=a[i];
		a[i]=m;
	}
	private static boolean less(Comparable comparable1, Comparable comparable2) {
		// �ж�comparable1�Ƿ�С��comparable2
		return comparable1.compareTo(comparable2)<0;
	}
}
