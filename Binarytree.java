
/**
 *	��������Node���󹹳ɣ�ÿ��Node�������һ�Լ�ֵ���������ӣ������Ӻ������ӣ���һ���ڵ���������ɡ�
 *	����һ�����ڵ�root������������ָ��һ����С�ڸýڵ������Ķ����������������ָ��һ�Ŵ��ڸýڵ�Ķ�������rootָ����ڵ㡣
 *  ���´��������Ӻ͸��Ĳ�����
 */
public class Binarytree<Key extends Comparable<Key>,Value> {
	private Node root;
	private class Node{
		private Key key;
		private Node left;
		private Node right;
		private Value val;
		private int N;
		public Node (Key key,Value val, int N){
			this.key=key;
			this.val=val;
			this.N=N;
		}
	}
	public int size(){
		//�������Ĵ�С
		return size(root);
	}
	private int size(Node node){
		if(root==null) return 0;
		else return node.N;
	}
	
	public Value get(Key key){
		//�õ���������keyֵ
		return get(root,key);
	}
	private Value get(Node x, Key key) {
		if(x==null) return null;
		int cmp=x.key.compareTo(key);
		if(cmp<0) return get(x.left, key);
		else if(cmp>0) return get(x.right, key);
		else return x.val;
	}
	public void put(Key key ,Value val){
		//����key��ֵ�������key�������򴴽��µ�Node����
		put(root,key,val);
	}
	private Node put(Node x, Key key, Value val) {
		if(x==null) return new Node(key,val,1);
		int cmp=x.key.compareTo(key);
		if(cmp>0) x.right=put(x.right,key,val);
		else if(cmp<0) x.left=put(x.left,key,val);
		else x.val=val;
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
}
