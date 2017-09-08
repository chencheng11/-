
/**
 *	二叉树又Node对象构成，每个Node对象包括一对键值、两条连接（左连接和右连接）和一个节点计数器构成。
 *	包含一个根节点root，他的做链接指向一颗由小于该节点所见的二叉查找树，右连接指向一颗大于该节点的二叉树。root指向根节点。
 *  以下代码包括添加和更改操作。
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
		//二叉树的大小
		return size(root);
	}
	private int size(Node node){
		if(root==null) return 0;
		else return node.N;
	}
	
	public Value get(Key key){
		//得到二叉树的key值
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
		//更改key的值，如果改key不存在则创建新的Node对象
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
