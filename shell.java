
/**
 * ϣ������ ϣ�������ǲ�������ĸĽ��������˲���������ٶȡ� ϣ�������˼����ʹ������������Ϊh��Ԫ�ض�������ġ������������֮ΪH�������顣
 * �����㷨����ѧ�ϻ����ܼ���������ƽ�����������Ǿ������������ܱ���ͨ�Ĳ�����������20%-40%;
 * �����е������С������ʱ�����ǿ��Խ��ܵģ����Ҵ���ʵ�ּ򵥣�����û�ж�����ڴ�ռ䡣
 */

public class shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;// h=1.4.13.40.121....
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[i]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
	}

	private static void exch(Comparable[] a, int j, int i) {
		Comparable com = a[j];
		a[j] = a[i];
		a[i] = com;

	}

	private static boolean less(Comparable comparable, Comparable comparable2) {
		return comparable.compareTo(comparable2) < 0;
	}
}
