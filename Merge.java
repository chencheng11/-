/**
 * 归并排序
 * 归并排序采用的是分治思想。时间复杂度是NlogN
 * 归并算法有两种实现方式：一种是自顶向下，一种是自底向上。以下代码是自顶向下实现归并排序。
 * 算法优化：归并排序在数据量比较少的时候效率不高，此时可以更改为选择排序。
 * 
 * 
 * 
 */
public class Merge {
	private static Comparable[] aux;// 辅助数组

	public static void sort(Comparable[] a) {
		//自顶向下的归并排序
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// 递归调用 将数组a[lo...hi]排序
		if (lo <= hi)
			return;
		int mid = lo + (hi - lo);
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		// 将两个有序数组合并成一个有序数组
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
		// 判断comparable1是否小于comparable2
		 return  comparable1.compareTo(comparable2)<0;
	}

}
