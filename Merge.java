/**
 * �鲢����
 * �鲢������õ��Ƿ���˼�롣ʱ�临�Ӷ���NlogN
 * �鲢�㷨������ʵ�ַ�ʽ��һ�����Զ����£�һ�����Ե����ϡ����´������Զ�����ʵ�ֹ鲢����
 * �㷨�Ż����鲢�������������Ƚ��ٵ�ʱ��Ч�ʲ��ߣ���ʱ���Ը���Ϊѡ������
 * 
 * 
 * 
 */
public class Merge {
	private static Comparable[] aux;// ��������

	public static void sort(Comparable[] a) {
		//�Զ����µĹ鲢����
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// �ݹ���� ������a[lo...hi]����
		if (lo <= hi)
			return;
		int mid = lo + (hi - lo);
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		// ��������������ϲ���һ����������
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j]))
				a[k] = aux[i++];                            
			else
				a[k] = a[j++];
		}
	}

	private static boolean less(Comparable comparable1, Comparable comparable2) {
		// �ж�comparable1�Ƿ�С��comparable2
		 return  comparable1.compareTo(comparable2)<0;
	}

}
