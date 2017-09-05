/**
 * 快速排序
 * 快速排序实现简单、原地排序，适用于各种不同的输入数据而且比其他的排序要更加快速，所以是应用最广泛的排序算法。
 *  快速排序时间复杂度为NlogN 并且空间复杂度也很小。
 *  算法改进：
 *  1。对于小数组插入排序比快速排序速度更快
 *  2。在实际应用中会包含很多重复的元素，在此就可以使用三项切分快速排序算法。将数组分割别对应小于、等于、大于、
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
		//以lo为基础进行切分， 使i的左边小于a[lo] 右边大于a[lo]
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
		//交换数组a中的i和j的位置
		Comparable m=a[j];
		a[j]=a[i];
		a[i]=m;
	}
	private static boolean less(Comparable comparable1, Comparable comparable2) {
		// 判断comparable1是否小于comparable2
		return comparable1.compareTo(comparable2)<0;
	}
}
