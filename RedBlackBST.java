/**
 *	�����ʵ�ֲ���
 * ������ǻ��ڶ��������ʵ�ֵġ��ǶԶ�����������Ż�������ƽ���������һ�֣���Ϊ���������������ӡ�
 * ���۽��Ĳ���˳����Σ������������������ƽ���
 */
public class RedBlackBST <Key extends Comparable<Key>,Value> {
	private Node root;
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	
	private class Node{
		private Key key;
		private Node left;
		private Node right;
		private Value val;
		private boolean color;
		private int N;
		public Node (Key key,Value val, int N,boolean color){
			this.key=key;
			this.val=val;
			this.N=N;
			this.color=color;
		}
	}
	private boolean isRED(Node x){
		//�ж���ɫ
		if(x==null)return false;
		return x.color==RED;
	}
	private Node rotateLeft(Node h){
		//����ת
		Node x=h.right;
		h.right=x.left;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}	private Node rotateRight(Node h){
		//����ת
		Node x=h.left;
		h.left=x.right;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	public void flipColors(Node h){
		//��ɫ��ת
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=BLACK;
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
		if(x==null) return new Node(key,val,1,RED);
		int cmp=x.key.compareTo(key);
		if(cmp>0) x.right=put(x.right,key,val);
		else if(cmp<0) x.left=put(x.left,key,val);
		else x.val=val;
		if(isRED(x.right)&&!isRED(x.left)) x=rotateLeft(x);
		if(isRED(x.left)&&!isRED(x.left.left)) x=rotateRight(x);
		if(isRED(x.left)&&!isRED(x.right)) flipColors(x);
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
}
