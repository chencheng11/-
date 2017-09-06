
/**
 * 希尔排序 希尔排序是插入排序的改进，增加了插入排序的速度。 希尔排序的思想是使数组中任意间隔为h的元素都是有序的。这样的数组称之为H有序数组。
 * 此种算法在数学上还不能计算出所需的平均次数，但是经过测试性能能比普通的插入排序提升20%-40%;
 * 对于中等数组大小的排序时间上是可以接受的，而且代码实现简单，并且没有额外的内存空间。
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
